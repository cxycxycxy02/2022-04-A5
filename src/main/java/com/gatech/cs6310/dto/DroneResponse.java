package com.gatech.cs6310.dto;

import com.gatech.cs6310.entites.Drone;
import com.gatech.cs6310.entites.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DroneResponse {
    private List<Drone> droneList;
    private Drone drone;
    private String errorMessage;

}
