package com.gatech.cs6310.mapper;

import com.gatech.cs6310.entites.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
public interface LoginMapper {

     @Select("select * from user where account = #{account,jdbcType = VARCHAR}")
     User userInquiryByAccount(@Param("account") String account);
}
