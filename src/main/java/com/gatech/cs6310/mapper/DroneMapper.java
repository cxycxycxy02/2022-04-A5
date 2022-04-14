package com.gatech.cs6310.mapper;

import com.gatech.cs6310.entites.Drone;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DroneMapper {

    @Select("select * from Drone storeName = #{storeName,jdbcType=VARCHAR}")
    List<Drone> inquiryDronesByStoreName(String StoreName);

    @Delete("Delete * from Drone where DroneId = #{DroneId,jdbcType=INTEGER}")
    void removeDrone(Integer DroneId);

    @Insert("insert into Store (capacity, leftTrip, storeName,pilotAccount) values ("
            + "#{capacity,jdbcType=INTEGER},#{capacity,jdbcType=INTEGER}, #{storeName,jdbcType=VARCHAR},#{pilotAccount,jdbcType=VARCHAR})")
    @Options(useGeneratedKeys = true, keyProperty = "DroneId", keyColumn = "DroneId")
    int addDrone(Drone drone);

    @Update("update Drone set storeName = #{account,jdbcType=VARCHAR}"
            +"capacity = #{capacity,jdbcType=INTEGER},leftTrip = #{leftTrip,jdbcType=INTEGER}, pilotAccount = #{pilotAccount,jdbcType=VARCHAR} "
            +"where DroneId = #{DroneId,jdbcType=INTEGER}"
    )
    void updateDrone(Drone drone);

    @Select("select * from Drone droneID = #{droneID,jdbcType=INTEGER}")
    Drone inquiryDroneByDroneId(Integer droneID);
}
