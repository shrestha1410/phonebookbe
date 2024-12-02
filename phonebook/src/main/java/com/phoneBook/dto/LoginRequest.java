package com.phoneBook.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class LoginRequest {
    private String mobileNumber;
    private String password;
}
