package com.gatech.cs6310.service;

import com.gatech.cs6310.dto.UserCommon;
import com.gatech.cs6310.dto.UserResponse;
import com.gatech.cs6310.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class LoginService {

    @Autowired
    private LoginMapper logMapper;

    public UserResponse passwordVerify(String account, String password){
        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();
        UserCommon user =  logMapper.userInquiryByAccount(account);
        if (Objects.isNull(user)){
            userResponse.errorMessage("ERROR:user_identifier_not_exists");
        }else if (!password.equals(user.getPassword())){
            userResponse.errorMessage("ERROR:user_password_wrong");
        }else{
            userResponse.userCommon(user);
        }
        return userResponse.build();
    };

    public UserResponse register(UserCommon newUser){
        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();
        UserCommon user =  logMapper.userInquiryByAccount(newUser.getAccount());
        if (Objects.isNull(user)){
            userResponse.userCommon(logMapper.userInsert(newUser));
        }else{
            userResponse.errorMessage("ERROR:user_already_exists");
        }
        return userResponse.build();
    }

    public UserResponse updateUserInfo(UserCommon user){
        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();
        UserCommon OldUser =  logMapper.userInquiryByAccount(user.getAccount());
        if (Objects.isNull(OldUser)){
            userResponse.errorMessage("ERROR:user_identifier_not_exists");
        } else{
            userResponse.userCommon(logMapper.userUpdate(user));
        }
        return userResponse.build();
    }

    public UserResponse deleteUser(UserCommon user){
        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();
        UserCommon OldUser =  logMapper.userInquiryByAccount(user.getAccount());
        if (Objects.isNull(OldUser)){
            userResponse.errorMessage("ERROR:user_identifier_not_exists");
        } else{
            userResponse.userCommon(logMapper.userDelete(user));
        }
        return userResponse.build();
    }

    public UserResponse userBulkInquiry(){
        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();
        userResponse.userList(logMapper.userBulkInquiry());
        return userResponse.build();
    }
}
