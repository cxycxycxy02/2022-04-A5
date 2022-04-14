package com.gatech.cs6310.mapper;

import com.gatech.cs6310.entites.Item;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ItemMapper {
    @Select("select * from item where storeName = #{storeName,jdbcType=VARCHAR}")
    List<Item> inquiryItemsByStore(String storeName);

    @Insert("insert into Item (unitPrice, itemName, storeName, weight) values ("
            + "#{unitPrice,jdbcType=INTEGER}, #{itemName,jdbcType=VARCHAR}, #{storeName,jdbcType=VARCHAR},#{weight,jdbcType=INTEGER})")
    void addItem(Item item);

    @Update("update Item set"
            +"weight = #{capacity,jdbcType=INTEGER},unitPrice = #{leftTrip,jdbcType=INTEGER}, itemName = #{itemName,jdbcType=VARCHAR}"
            +"where itemName = #{itemName,jdbcType=VARCHAR} and storeName = #{storeName,jdbcType=VARCHAR}"
    )
    void updateItem(Item item);

    @Select("select * from item where itemName = #{itemName,jdbcType=VARCHAR}")
    Item inquiryItemsByItemName(String itemName);
}
