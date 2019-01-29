package com.joey.user.jpa;

import com.joey.user.entity.TokenInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author EDZ
 */
public interface TokenJPA extends JpaRepository<TokenInfo,String>, JpaSpecificationExecutor<TokenInfo> {
}
