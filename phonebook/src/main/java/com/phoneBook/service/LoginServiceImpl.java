package com.phoneBook.service;

import com.phoneBook.dto.LoginRequest;
import com.phoneBook.entity.User;
import com.phoneBook.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements  LoginService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public Boolean loginCall(LoginRequest loginRequest) {
      User existinguser=userRepository.findByMobileNumberAndPassword(loginRequest.getMobileNumber(),loginRequest.getPassword());
      if(existinguser!=null){
        return true;
      } 
      return false;
    }
}
