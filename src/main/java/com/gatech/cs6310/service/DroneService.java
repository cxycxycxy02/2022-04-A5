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

    @Autowired
    DroneMapper droneMapper;

    @Autowired
    OrderMapper orderMapper;

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
        } else {
            droneResponse.drone((droneMapper.removeDrone(droneId)));
        }
        return droneResponse.build();
    }

    public DroneResponse addDrone(Drone drone){
        DroneResponse.DroneResponseBuilder droneResponse = DroneResponse.builder();
        droneResponse.drone((droneMapper.addDrone(drone)));
        return droneResponse.build();
    }
}
