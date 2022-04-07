package com.gatech.cs6310.service;

import com.gatech.cs6310.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    @Autowired
    private LoginMapper logMapper;

    public boolean passwordVerify(String account, String password){
        return password.equals(logMapper.userInquiryByAccount(account).getPassword());
    };
}
