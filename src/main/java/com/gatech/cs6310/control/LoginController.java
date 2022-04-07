package com.gatech.cs6310.control;

import com.gatech.cs6310.entites.User;
import com.gatech.cs6310.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/toLoginPage")
    @ResponseBody
    public boolean toLoginPage(User user){
        return loginService.passwordVerify(user.getAccount(), user.getPassword());
    }
}
