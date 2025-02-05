package com.example.l3.security;

import com.example.l3.dto.UserDto;
import com.example.l3.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import static com.example.l3.consts.SecurityConst.ROLE_PREFIX;

@Getter
@Setter
@AllArgsConstructor
@Slf4j
public class MyUserDetails implements UserDetails {
    private UserDto userDto;
    private final RoleService roleService;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        log.info(userDto.getRoleId().toString());
        if (Objects.isNull(userDto.getRoleId())) {
            //khong co role gi
            return Collections.emptyList();
        } else {
            return Collections.singleton(new SimpleGrantedAuthority(ROLE_PREFIX + roleService.getRoleById(userDto.getRoleId()).getRole()));
        }
    }

    @Override
    public String getPassword() {
        return this.userDto.getPassword();
    }

    @Override
    public String getUsername() {
        return this.userDto.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
