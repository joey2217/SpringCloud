package com.joey.user.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author EDZ
 * @create 2019-01-25 14:57
 * @desc User Data Object
 */
@Entity
@Data
@Table(name="user")
public class UserEntity{

    /**
     * ID 主键
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 账户
     */
    @Column(unique = true)
    private String username;

    /**
     * 密码
     */
    private String password;


}
