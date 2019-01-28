package com.joey.user.controller;

import com.joey.user.entity.UserEntity;
import com.joey.user.jpa.UserJPA;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation(value = "/",notes = "add user",httpMethod = "POST")
    @PostMapping("/")
    public boolean saveUser(@RequestBody @ApiParam(value = "User") UserEntity user){
        userJPA.save(user);
        return true;
    }
}
