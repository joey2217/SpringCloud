package com.joey.jwt.jpa;

import com.joey.jwt.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author EDZ
 * @create 2019-01-30 14:10
 * @desc UserJpa
 */
public interface UserJpa extends JpaRepository<UserEntity,Long> {

    /**
     * @param username
     * @return
     * 根据用户名获取用户
     */
    UserEntity findByUsername(String username);
}
