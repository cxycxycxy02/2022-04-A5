package com.gatech.cs6310.mapper;

import com.gatech.cs6310.entites.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ItemMapper {
    @Select("")
    List<Item> inquiryItemsByStore(@Param("storeName") String storeName);

    @Select("")
    List<Item> addItem(Item item);
}
