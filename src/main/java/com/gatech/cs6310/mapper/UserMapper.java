package com.gatech.cs6310.mapper;


import com.gatech.cs6310.dto.UserCommon;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserMapper {

     @Select("select * from user where account = #{account,jdbcType=VARCHAR}")
     UserCommon userInquiryByAccount(@Param("account") String account);

     @Select("select * from user")
     List<UserCommon> userBulkInquiry();

     @Insert("insert into USER (account, firstName, lastName, phone,password, role, credit, rating, tax,license, experience,assignDrone,StoreName) values ("
             + "#{account,jdbcType=VARCHAR},#{firstName,jdbcType=VARCHAR},#{lastName,jdbcType=VARCHAR},#{phone,jdbcType=VARCHAR},"
             +"#{password,jdbcType=VARCHAR},#{role,jdbcType=VARCHAR},#{credit,jdbcType=INTEGER},#{rating,jdbcType=INTEGER},"
             +"#{tax,jdbcType=VARCHAR},#{license,jdbcType=VARCHAR},#{experience,jdbcType=INTEGER},#{assignDrone,jdbcType=INTEGER},#{StoreName,jdbcType=VARCHAR})")
     void adminInsert (UserCommon user);

     @Delete("Delete * from user where account = #{account,jdbcType=VARCHAR}")
     void userDelete (@Param("account") String account);

     @Update("update user set account = #{account,jdbcType=VARCHAR},"
             +"firstName = #{firstName,jdbcType=VARCHAR},lastName = #{lastName,jdbcType=VARCHAR}, phone = #{phone,jdbcType=VARCHAR}, "
             +"password = #{password,jdbcType=VARCHAR},role = #{role,jdbcType=VARCHAR},credit = #{credit,jdbcType=INTEGER},rating = #{rating,jdbcType=INTEGER} "
             +",tax = #{tax,jdbcType=VARCHAR},license = #{license,jdbcType=VARCHAR},experience=#{experience,jdbcType=INTEGER},assignDrone=#{assignDrone,jdbcType=INTEGER}"
             +",StoreName = #{StoreName,jdbcType=VARCHAR}"
     )
     void userUpdate (UserCommon user);

     @Update("update user set account = #{account,jdbcType=VARCHAR}"
          +"firstName = #{firstName,jdbcType=VARCHAR},lastName = #{lastName,jdbcType=VARCHAR}, phone = #{phone,jdbcType=VARCHAR} "
          +"password = #{password,jdbcType=VARCHAR},role = #{role,jdbcType=VARCHAR},credit = #{credit,jdbcType=INTEGER},rating = #{rating,jdbcType=INTEGER} "
             +"tax = #{tax,jdbcType=VARCHAR},license = #{license,jdbcType=VARCHAR},experience=#{experience,jdbcType=INTEGER},assignDrone=#{assignDrone,jdbcType=INTEGER}"
             +"StoreName = #{StoreName,jdbcType=VARCHAR}"
     )
     UserCommon pilotUpdate (@Param("account") UserCommon user);

     @Insert("insert into USER (account, firstName, lastName, phone, password, role) values ("
             + "#{account,jdbcType=VARCHAR},#{firstName,jdbcType=VARCHAR},#{lastName,jdbcType=VARCHAR},#{phone,jdbcType=VARCHAR},"
             +"#{password,jdbcType=VARCHAR},#{role,jdbcType=VARCHAR})")
     void userInsert (UserCommon user);

}
