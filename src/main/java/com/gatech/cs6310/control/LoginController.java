package com.gatech.cs6310.control;

import com.gatech.cs6310.dto.UserCommon;
import com.gatech.cs6310.dto.UserResponse;
import com.gatech.cs6310.entites.User;
import com.gatech.cs6310.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/toLoginPage")
    @ResponseBody
    public UserResponse toLoginPage(User user){
        return loginService.passwordVerify(user.getAccount(), user.getPassword());
    }

    @PostMapping("/register")
    @ResponseBody
    public UserResponse register(UserCommon user){
        return loginService.register(user);
    }

    @PostMapping("/deleteUser")
    @ResponseBody
    public UserResponse deleteUser(UserCommon user){
        return loginService.deleteUser(user);
    }

    @PostMapping("/UpdateUserInfo")
    @ResponseBody
    public UserResponse UpdateUserInfo(UserCommon user){
        return loginService.updateUserInfo(user);
    }

    @PostMapping("/userBulkInquiry")
    @ResponseBody
    public UserResponse userBulkInquiry(){
        return loginService.userBulkInquiry();
    }
}
