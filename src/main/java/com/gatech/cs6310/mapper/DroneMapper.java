package com.gatech.cs6310.mapper;

import com.gatech.cs6310.entites.Drone;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DroneMapper {

    @Select("")
    List<Drone> inquiryDronesByStoreName(String StoreName);

    @Delete("")
    Drone removeDrone(Integer DroneId);

    @Insert("")
    Drone addDrone(Drone drone);

    @Update("")
    Drone updateDrone(Drone drone);

    @Select("")
    Drone inquiryDroneByDroneId(Integer StoreName);
}
