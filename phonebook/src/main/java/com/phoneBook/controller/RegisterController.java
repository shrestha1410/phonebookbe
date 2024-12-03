package com.phoneBook.controller;

import com.phoneBook.dto.RegisterUser;
import com.phoneBook.dto.UserDto;
import com.phoneBook.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    RegisterService registerService;
    @PostMapping("/")
    public Long registerNewUser(@RequestBody RegisterUser registerUser){
       return  registerService.registerNewUser(registerUser);
    }
    @GetMapping("/getUser/{id}")
    public UserDto getUserDetailsById(@PathVariable Long id){
        return registerService.getUser(id);
    }

}
