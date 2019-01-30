package com.joey.jwt.service.impl;

import com.joey.jwt.entity.UserEntity;
import com.joey.jwt.jpa.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

/**
 * @author EDZ
 * @create 2019-01-30 14:18
 * @desc UserDetailsServiceImpl
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserJpa userJpa;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userJpa.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(user.getUsername(),user.getPassword(),emptyList());
    }
}
