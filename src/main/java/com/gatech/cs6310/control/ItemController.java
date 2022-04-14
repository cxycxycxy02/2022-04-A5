package com.gatech.cs6310.control;

import com.gatech.cs6310.dto.ItemResponse;
import com.gatech.cs6310.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;

    @PostMapping("/inquiryItemsByStore")
    @ResponseBody
    public ItemResponse inquiryItemsByStore(String store){
        return itemService.inquiryItemsByStore(store);
    }

    @PostMapping("/addItem")
    @ResponseBody
    public ItemResponse addItem(String store){
        return itemService.inquiryItemsByStore(store);
    }
}
