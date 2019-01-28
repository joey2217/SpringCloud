package com.joey.user.jpa;

import com.joey.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Joey
 * @create 2019-01-28 21:53
 * @desc UserJPA
 */
public interface UserJPA extends JpaRepository<UserEntity,Integer> {
}
