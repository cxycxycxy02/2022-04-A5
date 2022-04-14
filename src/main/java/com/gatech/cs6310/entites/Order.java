package com.gatech.cs6310.entites;


import com.gatech.cs6310.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer orderId;
    private Integer droneId;
    private String pilotAccount;
    private String customerAccount;
    private Integer totalPrice;
    private Timestamp createTime;
    private Timestamp payTime;
    private Integer totalWeight;
    private String orderStatus;
    private String StoreName;
}

