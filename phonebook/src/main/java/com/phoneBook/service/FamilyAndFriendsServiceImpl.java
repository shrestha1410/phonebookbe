package com.phoneBook.service;

import com.phoneBook.dto.FamilyAndFriendsDto;
import com.phoneBook.dto.FamilyAndFriendsRequestDto;
import com.phoneBook.entity.FamilyAndFriends;
import com.phoneBook.entity.User;
import com.phoneBook.repository.FamilyAndFriendsRepository;
import com.phoneBook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class FamilyAndFriendsServiceImpl implements FamilyAndFriendsService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    FamilyAndFriendsRepository familyAndFriendsRepository;
    @Override
    public List<FamilyAndFriendsDto> getListByUserId(Long id) {
        Optional<User> user= userRepository.findById(id);
        List<FamilyAndFriendsDto> familyAndFriendsDtoList=new ArrayList<>();
        if(user.isPresent()){
            User existingUser=user.get();
            if(!existingUser.getFamilyAndFriend().isEmpty()) {
                List<FamilyAndFriends> familyAndFriendsExisting=existingUser.getFamilyAndFriend();
                for(FamilyAndFriends  fnf: familyAndFriendsExisting ) {
                    FamilyAndFriendsDto familyAndFriendsDto = FamilyAndFriendsDto.builder()
                            .firstName(fnf.getFirstName())
                            .lastName(fnf.getLastName())
                            .mobileNumber(fnf.getMobileNumber())
                            .addressLine1(fnf.getAddressLine1())
                            .addressLine2(fnf.getAddressLine2())
                            .build();
                    familyAndFriendsDtoList.add(familyAndFriendsDto);
                }
            }
        }
        return familyAndFriendsDtoList;
    }

    @Override
    public Long addFamilyAndFriend(FamilyAndFriendsRequestDto familyAndFriendsRequestDto,Long id) {
       Optional<User> existing=userRepository.findById(id);
       if(existing.isPresent()){
           FamilyAndFriends familyAndFriends=FamilyAndFriends.builder()
                   .user(existing.get())
                   .firstName(familyAndFriendsRequestDto.getFirstName())
                   .lastName(familyAndFriendsRequestDto.getLastName())
                   .mobileNumber(familyAndFriendsRequestDto.getMobileNumber())
                   .addressLine1(familyAndFriendsRequestDto.getAddressLine1())
                   .addressLine2(familyAndFriendsRequestDto.getAddressLine2())
                   .build();
        FamilyAndFriends familyAndFriends1New= familyAndFriendsRepository.save(familyAndFriends);
        return familyAndFriends1New.getId();
       }else{
           throw new RuntimeException("User is not exist with id:"+id);
       }
    }
}
