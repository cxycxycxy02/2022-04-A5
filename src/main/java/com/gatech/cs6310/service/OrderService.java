package com.gatech.cs6310.service;

import com.gatech.cs6310.dto.OrderResponse;
import com.gatech.cs6310.dto.UserCommon;
import com.gatech.cs6310.entites.Drone;
import com.gatech.cs6310.entites.Line;
import com.gatech.cs6310.entites.Order;
import com.gatech.cs6310.entites.Store;
import com.gatech.cs6310.mapper.DroneMapper;
import com.gatech.cs6310.mapper.OrderMapper;
import com.gatech.cs6310.mapper.StoreMapper;
import com.gatech.cs6310.mapper.UserMapper;
import com.gatech.cs6310.model.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Service
public class OrderService {

    private final UserMapper userMapper;
    private final OrderMapper orderMapper;
    private final DroneMapper droneMapper;
    private final StoreMapper storeMapper;

    @Autowired
    public OrderService(UserMapper userMapper, OrderMapper orderMapper, DroneMapper droneMapper,StoreMapper storeMapper) {
        this.userMapper = userMapper;
        this.orderMapper = orderMapper;
        this.droneMapper = droneMapper;
        this.storeMapper = storeMapper;
    }


    public OrderResponse computePrice(List<Line> lines, String userAccount) {
        OrderResponse.OrderResponseBuilder orderResponseBuilder = OrderResponse.builder();
        Integer result = 0;
        for (Line line : lines) {
            result += line.computeTotalPrice();
        }
        int credit = userMapper.userInquiryByAccount(userAccount).getCredit();
        if (credit - result > 0) {
            orderResponseBuilder.totalPrice(result);
        } else {
            orderResponseBuilder.errorMessage("customer_cant_afford_new_item");
        }
        return orderResponseBuilder.build();
    }

    private OrderResponse computeWeight(List<Line> lines) {
        OrderResponse.OrderResponseBuilder orderResponseBuilder = OrderResponse.builder();
        Integer result = 0;
        for (Line line : lines) {
            result += line.computeTotalWeight();
        }
        orderResponseBuilder.totalWeight(result);
        return orderResponseBuilder.build();
    }

    public OrderResponse placeOrder(List<Line> lines, String userAccount){
        OrderResponse.OrderResponseBuilder orderResponseBuilder = OrderResponse.builder();
        Order order = Order.builder()
                .createTime(new Timestamp(System.currentTimeMillis()))
                .customerAccount(userAccount)
                .totalPrice(this.computePrice(lines,userAccount).getTotalPrice())
                .totalWeight(this.computeWeight(lines).getTotalWeight())
                .orderStatus(OrderStatus.UNPAID.name())
                .build();
        order = orderMapper.startOrder(order);
        for(Line line: lines){
            line.setOrderId(order.getOrderId());
            orderMapper.addLine(line);
        }
        return orderResponseBuilder.order(order).build();
    }

    public void cancelOrder(Integer orderId){
        orderMapper.deleteOrder(orderId);

    }

    public OrderResponse inquiryOrdersByCustomerAccount(String customerAccount){
        OrderResponse.OrderResponseBuilder orderResponse = OrderResponse.builder();
        orderResponse.orderList(orderMapper.inquiryOrdersByCustomerAccount(customerAccount));
        return orderResponse.build();
    }

    public OrderResponse inquiryHistoryOrdersByCustomerAccount(String customerAccount){
        OrderResponse.OrderResponseBuilder orderResponse = OrderResponse.builder();
        orderResponse.orderList(orderMapper.inquiryHistoryOrdersByCustomerAccount(customerAccount));
        return orderResponse.build();
    }

    public OrderResponse paidOrder(Integer orderID, String customerAccount){
        OrderResponse.OrderResponseBuilder orderResponse = OrderResponse.builder();
        Order order = orderMapper.inquiryOrdersByOrderId(orderID);
        UserCommon user = userMapper.userInquiryByAccount(customerAccount);
        if (user.getCredit() - order.getTotalPrice() > 0) {
            orderMapper.inquiryOrdersByOrderId(orderID);
            order.setPayTime(new Timestamp(System.currentTimeMillis()));
            order.setOrderStatus(OrderStatus.WAIT_DELIVER.name());
            orderMapper.UpdateOrder(order);
            user.setCredit(user.getCredit() - order.getTotalPrice());
            userMapper.userUpdate(user);
        } else {
            orderResponse.errorMessage("ERROR:customer_cant_afford_new_item");
        }
        return orderResponse.build();

    }

    public OrderResponse deliverOrder(Integer orderID, String pilotAccount, Integer droneId){
        OrderResponse.OrderResponseBuilder orderResponse = OrderResponse.builder();
        Order order = orderMapper.inquiryOrdersByOrderId(orderID);
        UserCommon pilot = userMapper.userInquiryByAccount(pilotAccount);
        Drone drone = droneMapper.inquiryDroneByDroneId(droneId);
        List<Order> droneOrders = orderMapper.inquiryOrdersByDrone(droneId);
        if (drone.getLeftTrip() <= 0) {
            orderResponse.errorMessage("ERROR:drone_needs_fuel");
        } else if (Objects.nonNull(pilot.getAssignDrone()) || Objects.isNull(pilot.getLicense())){
            orderResponse.errorMessage("ERROR:drone_needs_pilot");
        } else if(drone.getCapacity()< computeDroneCurrentOrdersWeight(droneOrders) + order.getTotalWeight()){
            orderResponse.errorMessage("ERROR:drone_cant_carry_new_item");
        }else{
            order.setOrderStatus(OrderStatus.SHIPPED.name());
            order.setDroneId(droneId);
            order.setPilotAccount(pilotAccount);
            orderMapper.UpdateOrder(order);
            drone.setPilotAccount(pilotAccount);
            drone.setLeftTrip(drone.getLeftTrip()-1);
            droneMapper.updateDrone(drone);
            pilot.setAssignDrone(droneId);
            userMapper.pilotUpdate(pilot);
        }
        return orderResponse.build();

    }
    private Integer computeDroneCurrentOrdersWeight(List<Order> orders){
        Integer results = 0;
        for(Order order : orders){
            results += order.getTotalWeight();
        }
        return results;
    }

    public OrderResponse completeOrder(Integer orderID){
        OrderResponse.OrderResponseBuilder orderResponse = OrderResponse.builder();

        Order order = orderMapper.inquiryOrdersByOrderId(orderID);
        order.setOrderStatus(OrderStatus.COMPLETED.name());
        orderMapper.UpdateOrder(order);

        UserCommon pilot = userMapper.userInquiryByAccount(order.getPilotAccount());
        pilot.setAssignDrone(null);
        pilot.setExperience(pilot.getExperience() + 1);
        userMapper.pilotUpdate(pilot);

        Drone drone = droneMapper.inquiryDroneByDroneId(order.getDroneId());
        drone.setPilotAccount(null);
        drone.setLeftTrip(drone.getLeftTrip()-1);
        droneMapper.updateDrone(drone);

        Store store = storeMapper.inquiryByStoreName(order.getStoreName());
        store.setRevenue(store.getRevenue()+order.getTotalPrice());
        storeMapper.updateStore(store);

        return orderResponse.build();
    }
}
