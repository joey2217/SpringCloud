package com.joey.jwt.service.impl;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author EDZ
 * @create 2019-01-30 14:22
 * @desc GrantedAuthorityImpl
 */
public class GrantedAuthorityImpl implements GrantedAuthority {
    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
