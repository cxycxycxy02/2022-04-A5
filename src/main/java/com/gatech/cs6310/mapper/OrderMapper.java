package com.gatech.cs6310.mapper;

import com.gatech.cs6310.entites.Line;
import com.gatech.cs6310.entites.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Options(useGeneratedKeys = true, keyProperty = "orderId", keyColumn = "orderId")
    @Insert("insert into Order_Table (droneId, totalPrice, pilotAccount,customerAccount,storeName,totalWeight,createTime,payTime,orderStatus) values ("
            + "#{droneId,jdbcType=INTEGER},#{totalPrice,jdbcType=INTEGER}, #{pilotAccount,jdbcType=VARCHAR},#{customerAccount,jdbcType=VARCHAR},#{storeName,jdbcType=VARCHAR}" +
            ",#{totalPrice,jdbcType=INTEGER},#{createTime,jdbcType=TIMESTAMP},#{payTime,jdbcType=TIMESTAMP},,#{orderStatus,jdbcType=VARCHAR})")
    int startOrder( Order order);

    @Insert("insert into Line (unitPrice, itemName, storeName, weight,quantity,orderId) values ("
            + "#{unitPrice,jdbcType=INTEGER}, #{itemName,jdbcType=VARCHAR}, #{storeName,jdbcType=VARCHAR},#{weight,jdbcType=INTEGER},#{quantity,jdbcType=INTEGER},#{orderId,jdbcType=INTEGER})")
    Order addLine(@Param("line") Line line);

    @Delete("Delete * from Order_Table where orderId = #{orderId,jdbcType=INTEGER}")
    Order deleteOrder(Integer orderId);

    @Delete("")
    Order deleteLine(Integer orderId);

    @Select("select * from Order_Table where customerAccount = #{customerAccount,jdbcType=VARCHAR}")
    List<Order> inquiryOrdersByCustomerAccount(String customerAccount);

    @Select("select * from Order_Table where droneId = #{droneId,jdbcType=INTEGER}")
    List<Order> inquiryOrdersByDrone(Integer droneId);

    @Select("select * from Order_Table where orderId = #{orderId,jdbcType=INTEGER}")
    Order inquiryOrdersByOrderId(Integer orderId);

    @Update("update Order_Table set droneId = #{droneId,jdbcType=INTEGER},"
            +"pilotAccount = #{pilotAccount,jdbcType=VARCHAR},payTime = #{payTime,jdbcType=TIMESTAMP}, orderStatus = #{orderStatus,jdbcType=VARCHAR} "
            +"where orderId = #{orderId,jdbcType=INTEGER} "
    )
    void updateOrder(Order order);

    @Select("select * from history_order where customerAccount = #{customerAccount,jdbcType=INTEGER}")
    List<Order> inquiryHistoryOrdersByCustomerAccount(String customerAccount);

}
