package com.example.l3.service;

import com.example.l3.dto.ProfileEndDto;

import java.util.List;

public interface ProfileEndService {
    ProfileEndDto createProfileEnd(ProfileEndDto profileEndDto);
    ProfileEndDto getProfileEndById(Long id);
    List<ProfileEndDto> getAllProfileEnd();
    void deleteProfileEndById(Long id);
    ProfileEndDto updateProfileEnd(Long id, ProfileEndDto profileEndDto);
    ProfileEndDto submitProfileEnd(Long id, ProfileEndDto profileEndDto);
    ProfileEndDto updateProfileEndByLeader(Long id, ProfileEndDto profileEndDto);
}
