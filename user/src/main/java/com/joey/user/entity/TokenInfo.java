package com.joey.user.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author EDZ
 * @create 2019-01-29 11:11
 * @desc TokenInfoEntity
 */
@Data
@Table(name = "api_token_infos",schema = "user")
public class TokenInfo implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ati_id")
    private Long id;

    @Column(name = "ati_app_id")
    private String appId;

    @Column(name = "ati_token")
    private byte[] token;

    @Column(name = "ati_build_time")
    private String buildTime;

}
