package com.gatech.cs6310.dto;

import com.gatech.cs6310.entites.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponse {
    private List<Item> itemList;
    private String errorMessage;
    private Item item;
}
