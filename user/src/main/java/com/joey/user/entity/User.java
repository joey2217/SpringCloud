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
public class User implements Serializable {

    /**
     * ID 主键
     */
    @Id
    @GeneratedValue
    private  Integer id;

    /**
     * 账户
     */
    @Column(unique = true)
    private String username;

    /**
     * 名称
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 加密密码的盐
     */
    private String salt;

    /**
     * 用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
     */
    private byte state;

    /**
     * 角色
     * 立即从数据库中进行加载数据;
     */
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name = "Role", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private List<Role> roleList;

    @CreatedDate
    private Date gmtCreate;

    @LastModifiedDate
    private Date gmtModified;

}
