package com.example.l3.service;

import com.example.l3.dto.UserDto;
import com.example.l3.request.LoginRequestDto;
import com.example.l3.response.LoginResponseDto;

public interface UserService {
    UserDto register(UserDto userDto);
    LoginResponseDto login(LoginRequestDto loginRequestDto);
}
