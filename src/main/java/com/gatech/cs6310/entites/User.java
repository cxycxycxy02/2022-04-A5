package com.gatech.cs6310.entites;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//user admin(store crud)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    protected String firstName;
    protected String lastName;
    protected String phone;
    protected String account;
    protected String password;
}
