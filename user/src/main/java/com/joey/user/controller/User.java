package com.joey.user.controller;

import com.joey.user.entity.UserEntity;
import com.joey.user.jpa.UserJPA;
import com.joey.user.util.Base64Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Joey
 * @create 2019-01-28 21:58
 * @desc UserController
 */
@RestController
@RequestMapping("user")
@Api(value = "/user", description = "User Controller")
public class User extends Base{

    @Autowired
    private UserJPA userJPA;

    @ApiOperation(value = "",notes = "add user",httpMethod = "POST")
    @PostMapping("")
    public UserEntity saveUser(@RequestBody @ApiParam(value = "User") UserEntity user){
        String pass= Base64Util.encode(user.getPassword());
        user.setPassword(pass);
        UserEntity userEntity= userJPA.save(user);
        return userEntity;
    }
}
