package com.joey.jwt.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author EDZ
 * @create 2019-01-30 11:42
 * @desc UserEntity
 */
@Entity
@Table(name = "t_user")
@Data
public class UserEntity {

    @Id
    @GeneratedValue
    private long id;

    private String username;

    private String password;

}
