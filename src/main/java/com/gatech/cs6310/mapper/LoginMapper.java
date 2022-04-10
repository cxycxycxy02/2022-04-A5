package com.gatech.cs6310.mapper;


import com.gatech.cs6310.dto.UserCommon;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface LoginMapper {

     @Select("select * from user where account = #{account,jdbcType = VARCHAR}")
     UserCommon userInquiryByAccount(@Param("account") String account);

     @Select("select * from user")
     List<UserCommon> userBulkInquiry();

     //Todo
     @Insert("select * from user where account = #{account,jdbcType = VARCHAR}")
     UserCommon userInsert (@Param("account") UserCommon user);

     //Todo
     @Delete("select * from user where account = #{account,jdbcType = VARCHAR}")
     UserCommon userDelete (@Param("account") UserCommon user);

     //Todo
     @Update("select * from user where account = #{account,jdbcType = VARCHAR}")
     UserCommon userUpdate (@Param("account") UserCommon user);
}
