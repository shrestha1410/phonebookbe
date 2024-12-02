package com.phoneBook.dto;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class FamilyAndFriendsDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String pinCode;
}
