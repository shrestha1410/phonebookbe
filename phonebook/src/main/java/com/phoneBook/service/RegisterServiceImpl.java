package com.phoneBook.service;

import com.phoneBook.dto.RegisterUser;
import com.phoneBook.dto.UserDto;
import com.phoneBook.entity.User;
import com.phoneBook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RegisterServiceImpl implements RegisterService{
    @Autowired
    UserRepository userRepository;
    @Override
    public Long registerNewUser(RegisterUser registerUser) {
        User newUser= User.builder()
                .firstName(registerUser.getFirstName())
                .lastName(registerUser.getLastName())
                .mobileNumber(registerUser.getMobileNumber())
                .password(registerUser.getPassword())
                .pinCode(registerUser.getPinCode())
                .build();
        User user=userRepository.save(newUser);
        return  user.getId();
    }

    @Override
    public UserDto getUser(Long id) {
        Optional<User> user=userRepository.findById(id);
        if(user.get()!=null){
             User existingUser=user.get();
            return UserDto.builder()
                    .id(existingUser.getId())
                    .firstName(existingUser.getFirstName())
                    .lastName(existingUser.getLastName())
                    .build();
         }else{
             throw new RuntimeException("User doestNot exist with id :"+id);
         }
    }
}
