package com.example.l3.service;

import com.example.l3.dto.UserDto;
import com.example.l3.request.LoginRequestDto;
import com.example.l3.response.LoginResponseDto;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
    UserDto register(UserDto userDto);

    LoginResponseDto login(LoginRequestDto loginRequestDto);

    String logout(HttpServletRequest request);
}
