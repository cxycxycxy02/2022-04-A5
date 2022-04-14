package com.gatech.cs6310.service;

import com.gatech.cs6310.dto.ItemResponse;
import com.gatech.cs6310.entites.Item;
import com.gatech.cs6310.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Objects;

@Service
public class ItemService {

    final ItemMapper itemMapper;

    @Autowired
    public ItemService(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    public ItemResponse inquiryItemsByStore(String StoreName){
        ItemResponse.ItemResponseBuilder itemResponseBuilder = ItemResponse.builder();
        itemResponseBuilder.itemList(itemMapper.inquiryItemsByStore(StoreName));
        return itemResponseBuilder.build();
    }

    public ItemResponse addItem(Item item){
        ItemResponse.ItemResponseBuilder itemResponseBuilder = ItemResponse.builder();
        Item oldItem = itemMapper.inquiryItemsByItemName(item.getItemName());
        if(Objects.isNull(oldItem)){
            itemMapper.addItem(item);
            itemResponseBuilder.item(item);
        } else {
            itemResponseBuilder.errorMessage("ERROR:item_identifier_already_exists");
        }

        return itemResponseBuilder.build();
    }
    public ItemResponse updateItem(Item item){
        ItemResponse.ItemResponseBuilder itemResponseBuilder = ItemResponse.builder();
        Item oldItem = itemMapper.inquiryItemsByItemName(item.getItemName());
        if(Objects.isNull(oldItem)){
            itemResponseBuilder.errorMessage("ERROR:item_identifier_not_exists");
        } else{
            itemMapper.updateItem(item);
            itemResponseBuilder.item(item);
        }

        return itemResponseBuilder.build();
    }
}
