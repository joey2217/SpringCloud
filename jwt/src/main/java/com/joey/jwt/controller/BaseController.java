package com.joey.jwt.controller;

import com.joey.jwt.jpa.UserJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Joey
 * @create 2019-01-30 21:18
 * @desc BaseController
 */
@Slf4j
public abstract class BaseController {
    
    @Autowired
    protected UserJpa userJpa;
    
    @Autowired
    protected BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public List<String> getAuthentication(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
        List<String> list =new ArrayList<>();
        for (GrantedAuthority grantedAuthority :authorities) {
            log.info("权限列表：{}", grantedAuthority.getAuthority());
            list.add(grantedAuthority.getAuthority());
        }
        return list;
    }
    
//    public Object success(Object data){
//        return data;
//    }
//    
//    public Object resultWithCode(Object data, int code, HttpServletResponse response){
//        response.setStatus(code);
//        return data;
//    }
}