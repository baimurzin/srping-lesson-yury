package com.example.srpinglesson.security;

import com.example.srpinglesson.model.AuthUser;
import com.example.srpinglesson.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Set;
import java.util.stream.Collectors;

public class AuthUserDetailServiceImp implements UserDetailsService {

    @Autowired
    private AuthUserService authUserService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        AuthUser authUser = authUserService.findByLogin(s);
        if(authUser == null) {
            throw new UsernameNotFoundException("Invalid User");
        }
        else {
            Set<GrantedAuthority> grantedAuthorities = authUser.getRoles()
                    .stream()
                    .map(role -> new SimpleGrantedAuthority(role.toString().trim()))
                    .collect(Collectors.toSet());
            return new org
                    .springframework
                    .security
                    .core
                    .userdetails
                    .User(authUser.getLogin().trim(), authUser.getPassword().trim(),true,true,true, authUser.isActive(), grantedAuthorities);
            }
    }
}
