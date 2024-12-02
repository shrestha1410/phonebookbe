package com.phoneBook.dto;

import com.phoneBook.entity.FamilyAndFriends;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class FamilyAndFriendsRequestDto  {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String pinCode;
}
