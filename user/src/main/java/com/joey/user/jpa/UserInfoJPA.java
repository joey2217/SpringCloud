package com.joey.user.jpa;

import com.joey.user.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author EDZ
 */
public interface UserInfoJPA extends JpaRepository<UserInfo,String>, JpaSpecificationExecutor<UserInfo> {
}
