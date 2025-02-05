package com.example.l3.security;

import com.example.l3.consts.StoredProcedureConst;
import com.example.l3.dto.UserDto;
import com.example.l3.service.RoleService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Parameter;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.example.l3.consts.StoredProcedureConst.User.GET_USER_BY_USERNAME;
import static com.example.l3.consts.StoredProcedureConst.Mapper.USER_DTO_MAPPER;
import static com.example.l3.consts.StoredProcedureConst.Parameter.USERNAME;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final EntityManager entityManager;
    private final RoleService roleService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(GET_USER_BY_USERNAME, USER_DTO_MAPPER)
                .registerStoredProcedureParameter(USERNAME, String.class, ParameterMode.IN)
                .setParameter(USERNAME, username);

        UserDto userDto = (UserDto) query.getSingleResult();


        return new MyUserDetails(userDto,roleService);
    }
}
