package com.joey.user.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author EDZ
 * @create 2019-01-25 15:07
 * @desc Permission Data Object
 */
@Entity
@Data
public class Permission {

    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 类型，[menu|button]
     */
    @Column(columnDefinition = "enum('menu','button')")
    private String type;

    /**
     * 路径
     */
    private String url;

    /**
     * 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
     */
    private String permission;

    /**
     * 父编号
     */
    private Long parentId;

    /**
     * 父编号列表
     */
    private String parentIds;

    /**
     *  是否可用
     */
    private Boolean available = Boolean.FALSE;

    /**
     * roles
     */
    @ManyToMany
    @JoinTable(name = "RolePermission",joinColumns = {@JoinColumn(name = "permissionId")},inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<Role> roles;

    @CreatedDate
    private Date gmtCreate;

    @LastModifiedDate
    private Date gmtModified;

}
