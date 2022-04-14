package com.gatech.cs6310.entites;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Line {
    private Integer quantity;
    private Integer unitPrice;
    private String itemName;
    private Integer weight;
    private Integer orderId;
    public Integer computeTotalWeight(){
        return this.getWeight()*this.quantity;
    }
    public Integer computeTotalPrice(){
        return this.quantity*this.unitPrice;
    }

}
