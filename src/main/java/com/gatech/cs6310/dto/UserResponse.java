package com.gatech.cs6310.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private UserCommon userCommon;
    private String errorMessage;
    private List<UserCommon> userList;
}
