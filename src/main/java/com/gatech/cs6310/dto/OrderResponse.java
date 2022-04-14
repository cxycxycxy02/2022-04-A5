package com.gatech.cs6310.dto;

import com.gatech.cs6310.entites.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Integer totalPrice;
    private String errorMessage;
    private Integer totalWeight;
    private Order order;
    private List<Order> orderList;

}
