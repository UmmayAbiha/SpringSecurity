package com.abiha.springcloud.couponservice.controllers;

import com.abiha.springcloud.couponservice.model.User;
import com.abiha.springcloud.couponservice.repo.UserRepo;
import com.abiha.springcloud.couponservice.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/showReg")
    public String showRegistrationPage() {
        return "registerUser";

    }

    @PostMapping("/registerUser")
    public String register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return "login";
    }

    @GetMapping("/")
    public String getLoginPage(){
        return "login";

    }

    @PostMapping("/login")
    public String login(String email,String password){
       boolean loginResponse = securityService.login(email,password);
       if(loginResponse){
           return "index";
       }
       else
           return "login";
    }
}
