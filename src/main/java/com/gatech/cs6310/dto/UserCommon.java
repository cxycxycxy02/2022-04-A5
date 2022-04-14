package com.gatech.cs6310.dto;

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
    private String ssn;
    private String license;
    private Integer experience;
    private Integer assignDrone;
    private String storeName;
    private String firstName;
    private String lastName;
    private String phone;
    private String account;
    private String password;
    private Integer salary;
}
