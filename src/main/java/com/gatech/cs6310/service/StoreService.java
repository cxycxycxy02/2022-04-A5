package com.gatech.cs6310.service;

import com.gatech.cs6310.dto.StoreResponse;
import com.gatech.cs6310.entites.Store;
import com.gatech.cs6310.mapper.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StoreService {

    @Autowired
    private StoreMapper storeMapper;

    public StoreResponse inquiryByStoreName(String StoreName){
        StoreResponse.StoreResponseBuilder storeResponseBuilder = StoreResponse.builder();
        Store store  = storeMapper.inquiryByStoreName(StoreName);
        if (Objects.isNull(store)){
            storeResponseBuilder.errorMessage("ERROR:store_identifier_already_exists");
        } else{
            storeResponseBuilder.store(store);
        }
        return storeResponseBuilder.build();
    }

    public StoreResponse bulkInquiryAllStore(){
        StoreResponse.StoreResponseBuilder storeResponseBuilder = StoreResponse.builder();
        storeResponseBuilder.storeList(storeMapper.bulkInquiryAllStore());
        return storeResponseBuilder.build();
    }

    public StoreResponse addStore(Store store){
        StoreResponse.StoreResponseBuilder storeResponseBuilder = StoreResponse.builder();
        Store oldStore  = storeMapper.inquiryByStoreName(store.getStoreName());
        if (Objects.nonNull(store)){
            storeResponseBuilder.errorMessage("ERROR:store_identifier_not_exists");
        } else{
            storeResponseBuilder.store(storeMapper.addStore(store));
        }
        return storeResponseBuilder.build();
    }
}
