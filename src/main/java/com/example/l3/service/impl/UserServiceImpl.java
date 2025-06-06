package com.example.l3.service.impl;

import com.example.l3.commons.exception.ErrorMessages;
import com.example.l3.commons.exception.OctException;
import com.example.l3.consts.ConstParameter;
import com.example.l3.dto.UserDto;
import com.example.l3.helper.JsonHelper;
import com.example.l3.request.LoginRequestDto;
import com.example.l3.response.LoginResponseDto;
import com.example.l3.security.JwtProvider;
import com.example.l3.service.UserService;
import com.example.l3.validator.UserValidator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.example.l3.consts.StoredProcedureConst.Mapper.USER_DTO_MAPPER;
import static com.example.l3.consts.StoredProcedureConst.Parameter.USER_JSON;
import static com.example.l3.consts.StoredProcedureConst.User.CREATE_USER;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final EntityManager entityManager;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final UserValidator userValidator;
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public UserDto register(UserDto userDto) {
        userValidator.checkUser(userDto);
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
        if (authentication.isAuthenticated()) {
            loginResponseDto.setUsername(loginRequestDto.getUsername());
            loginResponseDto.setToken(jwtProvider.generateToken(loginRequestDto.getUsername()));

            List<String> roles = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            loginResponseDto.setRole(roles);
        } else {
            throw new OctException(ErrorMessages.NOT_AUTHENTICATE);
        }
        redisTemplate.opsForValue().set(ConstParameter.ACCESS_TOKEN + loginRequestDto.getUsername(), loginResponseDto.getToken(), 30, TimeUnit.MINUTES);
        return loginResponseDto;
    }

    @Override
    public String logout(HttpServletRequest request) {

        String token = request.getHeader("access-token");
        if (!StringUtils.hasLength(token)) {
            throw new OctException(ErrorMessages.TOKEN_NOT_FOUND);
        }
        String username = jwtProvider.extractUsername(token);
        Date expirationDate = jwtProvider.extractExpiration(token);
        long timeout = (expirationDate.getTime() - System.currentTimeMillis()) / (1000 * 60); //expiration time in minutes
        if (username != null) {
            redisTemplate.delete(ConstParameter.ACCESS_TOKEN + username);
            redisTemplate.opsForValue().set(ConstParameter.BLACK_LIST + username, token, timeout, TimeUnit.MINUTES);
            SecurityContextHolder.clearContext();
            return "Logout successful";
        } else {
            throw new OctException(ErrorMessages.TOKEN_NOT_FOUND);
        }
    }
}
