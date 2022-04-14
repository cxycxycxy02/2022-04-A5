package com.gatech.cs6310.control;

import com.gatech.cs6310.dto.UserCommon;
import com.gatech.cs6310.dto.UserResponse;
import com.gatech.cs6310.encryption.AesUtil;
import com.gatech.cs6310.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/toLoginPage")
    @ResponseBody
    public UserResponse toLoginPage(@RequestBody UserCommon user){
        System.out.println(user.toString());
        return userService.passwordVerify(user.getAccount(), user.getPassword());
    }

    @PostMapping("/adminRegister")
    @ResponseBody
    public UserResponse adminRegister(@RequestBody UserCommon user){
        return userService.adminRegister(user);
    }

    @PostMapping("/deleteUser")
    @ResponseBody
    public UserResponse deleteUser(@RequestBody UserCommon user){
        return userService.deleteUser(user);
    }

    @PostMapping("/updateUserInfo")
    @ResponseBody
    public UserResponse UpdateUserInfo(@RequestBody UserCommon user){
        return userService.updateUserInfo(user);
    }

    @PostMapping("/userBulkInquiry")
    @ResponseBody
    public UserResponse userBulkInquiry(){
        return userService.userBulkInquiry();

    }
    @PostMapping("/register")
    @ResponseBody
    public UserResponse register(@RequestBody UserCommon user){
        return userService.register(user);
    }
}
