package com.joey.user.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author EDZ
 * @create 2019-01-29 11:05
 * @desc UserInfoEntity
 */
@Data
@Entity
@Table(name = "api_user_infos", schema = "user")
public class UserInfo implements Serializable {

    @Id
    @Column(name = "aui_app_id")
    private String appId;

    @Column(name = "aui_app_secret")
    private byte[] appSecret;

    @Column(name = "aui_status")
    private int status;

    @Column(name = "aui_day_request_count")
    private int dayRequestCount;

    @Column(name = "aui_ajax_bind_ip")
    private String ajaxBindIp;

    @Column(name = "aui_mark")
    private String mark;
}
