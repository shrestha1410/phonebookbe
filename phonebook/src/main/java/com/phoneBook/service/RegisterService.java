package com.phoneBook.service;

import com.phoneBook.dto.RegisterUser;
import com.phoneBook.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface RegisterService {
    Long registerNewUser(RegisterUser registerUser);
    UserDto getUser(Long id);
}
