package com.gatech.cs6310.entites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private String itemName;
    private Integer weight;
    private Integer unit_price;
    private String storeName;

}
