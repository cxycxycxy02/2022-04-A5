package com.gatech.cs6310.mapper;

import com.gatech.cs6310.entites.Line;
import com.gatech.cs6310.entites.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Insert("")
    Order startOrder(@Param("Order") Order order);

    @Insert("")
    Order addLine(@Param("line") Line line);

    @Delete("")
    Order deleteOrder(Integer orderId);

    @Delete("")
    Order deleteLine(Integer orderId);

    @Select("")
    List<Order> inquiryOrdersByCustomerAccount(String customerAccount);

    @Select("")
    List<Order> inquiryOrdersByDrone(Integer drone);

    @Select("")
    Order inquiryOrdersByOrderId(Integer orderId);

    @Update("")
    Order UpdateOrder(@Param("Order") Order order);

    @Select("")
    List<Order> inquiryHistoryOrdersByCustomerAccount(String customerAccount);

}
