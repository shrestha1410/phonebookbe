package com.phoneBook.service;

import com.phoneBook.dto.FamilyAndFriendsDto;
import com.phoneBook.dto.FamilyAndFriendsRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FamilyAndFriendsService {
    public List<FamilyAndFriendsDto> getListByUserId(Long id);
    public Long addFamilyAndFriend(FamilyAndFriendsRequestDto familyAndFriendsRequestDto,Long id);
}
