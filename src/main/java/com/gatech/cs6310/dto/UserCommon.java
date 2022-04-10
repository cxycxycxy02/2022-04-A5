package com.gatech.cs6310.dto;

import com.gatech.cs6310.entites.Drone;
import com.gatech.cs6310.entites.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCommon {
    private String role;
    private Integer credit;
    private Integer rating;
    private String tax;
    private String license;
    private Integer experience;
    private Drone assignDrone;
    private String StoreName;
    private String errorMessage;
    private String firstName;
    private String lastName;
    private String phone;
    private String account;
    private String password;
}
