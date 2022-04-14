package com.gatech.cs6310.control;

import com.gatech.cs6310.dto.OrderResponse;
import com.gatech.cs6310.entites.Line;
import com.gatech.cs6310.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/computePrice")
    @ResponseBody
    public OrderResponse toLoginPage(@RequestBody List<Line> lines, String userAccount){
        return orderService.computePrice(lines,userAccount);
    }

    @PostMapping("/placeOrder")
    @ResponseBody
    public OrderResponse placeOrder(@RequestBody List<Line> lines, String userAccount){
        return orderService.placeOrder(lines,userAccount);
    }

    @PostMapping("/cancelOrder")
    @ResponseBody
    public void cancelOrder(Integer orderId){
       orderService.cancelOrder(orderId);
    }

    @PostMapping("/inquiryOrdersByCustomerAccount")
    @ResponseBody
    public OrderResponse inquiryOrdersByCustomerAccount(String account){
        return orderService.inquiryOrdersByCustomerAccount(account);
    }

    @PostMapping("/paidOrder")
    @ResponseBody
    public OrderResponse paidOrder(Integer orderID, String customerAccount){
        return orderService.paidOrder(orderID,customerAccount);
    }

    @PostMapping("/inquiryHistoryOrdersByCustomerAccount")
    @ResponseBody
    public OrderResponse inquiryHistoryOrdersByCustomerAccount(String account){
        return orderService.inquiryHistoryOrdersByCustomerAccount(account);
    }

    @PostMapping("/deliverOrder")
    @ResponseBody
    public OrderResponse deliverOrder(Integer orderId, String pilotAccount, Integer DroneId){
        return orderService.deliverOrder(orderId, pilotAccount, DroneId);
    }

    @PostMapping("/completeOrder")
    @ResponseBody
    public OrderResponse completeOrder(Integer orderId){
        return orderService.completeOrder(orderId);
    }
}
