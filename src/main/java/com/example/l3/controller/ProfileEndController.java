package com.example.l3.controller;

import com.example.l3.commons.OctResponse;
import com.example.l3.dto.ProfileEndDto;
import com.example.l3.service.ProfileEndService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profile-end")
public class ProfileEndController {
    private final ProfileEndService profileEndService;

    @PostMapping()
    public OctResponse<ProfileEndDto> createProfileEnd(@RequestBody ProfileEndDto profileEndDto) {
        return OctResponse.build(profileEndService.createProfileEnd(profileEndDto), "create profile end successfully");
    }

    @GetMapping("/{id}")
    public OctResponse<ProfileEndDto> getProfileEndById(@PathVariable("id") Long id) {
        return OctResponse.build(profileEndService.getProfileEndById(id), "get profile end with id: " + id + " successfully");
    }

    @GetMapping("/getAll")
    public OctResponse<List<ProfileEndDto>> getAllProfileEnd() {
        return OctResponse.build(profileEndService.getAllProfileEnd(), "get all profile end successfully");
    }

    @DeleteMapping("/{id}")
    public OctResponse<String> deleteProfileEndById(@PathVariable("id") Long id) {
        profileEndService.deleteProfileEndById(id);
        return OctResponse.build("delete profile end with id: " + id + " successfully");
    }

    @PutMapping("/{id}")
    public OctResponse<ProfileEndDto> updateProfileEnd(@PathVariable("id") Long id, @RequestBody ProfileEndDto profileEndDto) {
        return OctResponse.build(profileEndService.updateProfileEnd(id, profileEndDto), "update profile end with id: " + id + " successfully");
    }

    @PutMapping("/submit/{id}")
    public OctResponse<ProfileEndDto> submitProfileEnd(@PathVariable("id") Long id, @RequestBody ProfileEndDto profileEndDto) {
        return OctResponse.build(profileEndService.submitProfileEnd(id, profileEndDto), "submit profile end with id: " + id + " successfully");
    }

}
