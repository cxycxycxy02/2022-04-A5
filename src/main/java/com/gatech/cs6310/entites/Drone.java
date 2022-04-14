package com.gatech.cs6310.entites;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drone {
    private String storeName;
    private Integer droneId;
    private Integer capacity;
    private Integer leftTrip;
    private String pilotAccount;
}


