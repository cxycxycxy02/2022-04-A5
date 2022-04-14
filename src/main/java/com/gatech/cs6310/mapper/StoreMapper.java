package com.gatech.cs6310.mapper;


import com.gatech.cs6310.entites.Store;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StoreMapper {

    @Select("select * from store where storeName = #{storeName,jdbcType=VARCHAR}")
    Store inquiryByStoreName(String StoreName);

    @Select("select * from store")
    List<Store> bulkInquiryAllStore();

    @Insert("insert into Store (revenue, storeName) values ("
            + "#{revenue,jdbcType=INTEGER}, #{storeName,jdbcType=VARCHAR})")
    void addStore(Store store);

    @Update("update Store set "
            +"revenue = #{revenue,jdbcType=INTEGER}"
            +"where storeName = #{storeName,jdbcType=VARCHAR}"
    )
    void updateStore(Store store);
}
