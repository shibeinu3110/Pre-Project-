package com.example.l3.service.impl;

import com.example.l3.commons.exception.ErrorMessages;
import com.example.l3.commons.exception.OctException;
import com.example.l3.dto.UserDto;
import com.example.l3.helper.JsonHelper;
import com.example.l3.request.LoginRequestDto;
import com.example.l3.response.LoginResponseDto;
import com.example.l3.security.JwtProvider;
import com.example.l3.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.l3.consts.StoredProcedureConst.User.CREATE_USER;
import static com.example.l3.consts.StoredProcedureConst.Parameter.USER_JSON;
import static com.example.l3.consts.StoredProcedureConst.Mapper.USER_DTO_MAPPER;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final EntityManager entityManager;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    @Override
    public UserDto register(UserDto userDto) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(CREATE_USER, USER_DTO_MAPPER)
                .registerStoredProcedureParameter(USER_JSON, String.class, ParameterMode.IN)
                .setParameter(USER_JSON, JsonHelper.toJson(userDto));
        query.execute();
        return userDto;
    }

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        LoginResponseDto loginResponseDto = new LoginResponseDto();

        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword()));
        if(authentication.isAuthenticated()) {
            loginResponseDto.setUsername(loginRequestDto.getUsername());
            loginResponseDto.setToken(jwtProvider.generateToken(loginRequestDto.getUsername()));

            List<String> roles = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            loginResponseDto.setRole(roles);
        } else {
            throw new OctException(ErrorMessages.NOT_AUTHENTICATE);
        }
        return loginResponseDto;
    }
}
