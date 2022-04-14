package com.gatech.cs6310.control;

import com.gatech.cs6310.dto.StoreResponse;
import com.gatech.cs6310.entites.Store;
import com.gatech.cs6310.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/store")
public class StoreController {
    final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/inquiryByStoreName")
    @ResponseBody
    public StoreResponse inquiryByStoreName(String storeName){
        return storeService.inquiryByStoreName(storeName);
    }

    @PostMapping("/bulkInquiryAllStore")
    @ResponseBody
    public StoreResponse bulkInquiryAllStore(){
        return storeService.bulkInquiryAllStore();
}

    @PostMapping("/addStore")
    @ResponseBody
    public StoreResponse addStore(@RequestBody Store store){
        return storeService.addStore(store);
    }

    @PostMapping("/updateStore")
    @ResponseBody
    public StoreResponse updateStore(@RequestBody Store store){
        return storeService.updateStore(store);
    }
}
