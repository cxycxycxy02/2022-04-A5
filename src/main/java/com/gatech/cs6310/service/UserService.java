package com.gatech.cs6310.service;

import com.gatech.cs6310.dto.UserCommon;
import com.gatech.cs6310.dto.UserResponse;
import com.gatech.cs6310.encryption.AesUtil;
import com.gatech.cs6310.mapper.UserMapper;
import com.gatech.cs6310.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class UserService {

    @Autowired
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserResponse passwordVerify(String account, String password){
        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();
        UserCommon user =  userMapper.userInquiryByAccount(account);
        if (Objects.isNull(user)){
            userResponse.errorMessage("ERROR:user_identifier_not_exists");
        }else if (!password.equals(AesUtil.decrypt(user.getPassword()))){
            userResponse.errorMessage("ERROR:user_password_wrong");
        }else{
            userResponse.userCommon(user);
        }
        return userResponse.build();
    };

    public UserResponse adminRegister(UserCommon newUser){
        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();
        UserCommon user =  userMapper.userInquiryByAccount(newUser.getAccount());
        if (Objects.isNull(user)){
            userMapper.adminInsert(newUser);
            newUser.setPassword(AesUtil.encrypt(newUser.getPassword()));
            userResponse.userCommon(userMapper.userInquiryByAccount(newUser.getAccount()));
        }else{
            userResponse.errorMessage("ERROR:user_already_exists");
        }
        return userResponse.build();
    }

    public UserResponse register(UserCommon newUser){
        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();
        UserCommon user =  userMapper.userInquiryByAccount(newUser.getAccount());
        if (Objects.isNull(user)){
            newUser.setRole(Role.CUSTOMER.name());
            newUser.setPassword(AesUtil.encrypt(newUser.getPassword()));
            userMapper.userInsert(newUser);
            userResponse.userCommon(userMapper.userInquiryByAccount(newUser.getAccount()));
        }else{
            userResponse.errorMessage("ERROR:user_already_exists");
        }
        return userResponse.build();
    }

    public UserResponse updateUserInfo(UserCommon user){
        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();
        UserCommon OldUser =  userMapper.userInquiryByAccount(user.getAccount());
        if (Objects.isNull(OldUser)){
            userResponse.errorMessage("ERROR:user_identifier_not_exists");
        } else{
            userMapper.userUpdate(user);
            userResponse.userCommon(userMapper.userInquiryByAccount(user.getAccount()));
        }
        return userResponse.build();
    }

    public UserResponse deleteUser(UserCommon user){
        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();
        UserCommon OldUser =  userMapper.userInquiryByAccount(user.getAccount());
        if (Objects.isNull(OldUser)){
            userResponse.errorMessage("ERROR:user_identifier_not_exists");
        }
        return userResponse.build();
    }

    public UserResponse userBulkInquiry(){
        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();
        userResponse.userList(userMapper.userBulkInquiry());
        return userResponse.build();
    }

    public UserResponse userInquiryByStoreName(String storeName){
        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();
        userResponse.userList(userMapper.userInquiryByStoreName(storeName));
        return userResponse.build();
    }
}
