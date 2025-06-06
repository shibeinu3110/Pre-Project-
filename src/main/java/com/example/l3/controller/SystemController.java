package com.example.l3.controller;

import com.example.l3.commons.OctResponse;
import com.example.l3.dto.UserDto;
import com.example.l3.request.LoginRequestDto;
import com.example.l3.response.LoginResponseDto;
import com.example.l3.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import static com.example.l3.consts.SecurityConst.SECRET_STRENGTH;

@RestController
@RequestMapping("/public")
@RequiredArgsConstructor

public class SystemController {
    private final UserService userService;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(SECRET_STRENGTH);

    @PostMapping("/register")
    public OctResponse<UserDto> register(@RequestBody UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return OctResponse.build(userService.register(userDto));
    }

    @PostMapping("/login")
    public OctResponse<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        return OctResponse.build(userService.login(loginRequestDto));
    }

    @PostMapping("/logout")
    public OctResponse<String> logout(HttpServletRequest request) {
        return OctResponse.build(userService.logout(request));
    }
}
