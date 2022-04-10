package com.gatech.cs6310.mapper;


import com.gatech.cs6310.entites.Store;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StoreMapper {
    //TODO
    @Select("")
    Store inquiryByStoreName(String StoreName);
    //TODO
    @Select("")
    List<Store> bulkInquiryAllStore();

}
