package com.gatech.cs6310.dto;

import com.gatech.cs6310.entites.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreResponse {
    private Store store;
    private String errorMessage;
    private List<Store> storeList;

}
