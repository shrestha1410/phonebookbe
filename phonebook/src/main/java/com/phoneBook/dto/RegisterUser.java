package com.phoneBook.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegisterUser {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String password;
    private String pinCode;

}
