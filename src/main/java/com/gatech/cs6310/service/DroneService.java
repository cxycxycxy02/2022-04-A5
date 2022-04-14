package com.gatech.cs6310.service;

import com.gatech.cs6310.dto.DroneResponse;
import com.gatech.cs6310.entites.Drone;
import com.gatech.cs6310.entites.Order;
import com.gatech.cs6310.mapper.DroneMapper;
import com.gatech.cs6310.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneService {

    final DroneMapper droneMapper;

    final OrderMapper orderMapper;

    @Autowired
    public DroneService(DroneMapper droneMapper, OrderMapper orderMapper) {
        this.droneMapper = droneMapper;
        this.orderMapper = orderMapper;
    }

    public DroneResponse inquiryDronesByStore(String StoreName){
        DroneResponse.DroneResponseBuilder droneResponse = DroneResponse.builder();
        droneResponse.droneList((droneMapper.inquiryDronesByStoreName(StoreName)));
        return droneResponse.build();
    }

    public DroneResponse removeDrone(Integer droneId){
        List<Order> orders = orderMapper.inquiryOrdersByDrone(droneId);
        DroneResponse.DroneResponseBuilder droneResponse = DroneResponse.builder();
        if(orders.size() != 0){
            droneResponse.errorMessage("order_exist_drone_cant_remove");
        }
        return droneResponse.build();
    }

    public DroneResponse addDrone(Drone drone){
        DroneResponse.DroneResponseBuilder droneResponse = DroneResponse.builder();
        droneMapper.addDrone(drone);
        droneResponse.drone(droneMapper.inquiryDroneByDroneId(drone.getDroneId()));
        return droneResponse.build();
    }

    public DroneResponse inquiryAllDrones(){
        DroneResponse.DroneResponseBuilder droneResponse = DroneResponse.builder();
        droneResponse.droneList((droneMapper.inquiryAllDrones()));
        return droneResponse.build();
    }

    public DroneResponse updateDrone(Drone drone){
        DroneResponse.DroneResponseBuilder droneResponse = DroneResponse.builder();
        droneMapper.updateDrone(drone);
        droneResponse.drone(droneMapper.inquiryDroneByDroneId(drone.getDroneId()));
        return droneResponse.build();
    }
}
