package com.phoneBook.controller;

import com.phoneBook.dto.LoginRequest;
import com.phoneBook.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;

    @GetMapping("/")
    public String login(@RequestBody LoginRequest loginRequest) {
        return loginService.loginCall(loginRequest);
    }
}
