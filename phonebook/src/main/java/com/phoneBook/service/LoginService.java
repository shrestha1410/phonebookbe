package com.phoneBook.service;

import com.phoneBook.dto.LoginRequest;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    public String loginCall(LoginRequest loginRequest);
}
