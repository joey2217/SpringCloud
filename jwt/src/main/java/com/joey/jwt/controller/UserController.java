package com.joey.jwt.controller;

import com.joey.jwt.entity.UserEntity;
import com.joey.jwt.exception.UsernameIsExitedException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Joey
 * @create 2019-01-30 21:34
 * @desc User
 */
@RestController
@RequestMapping("/users")
@Slf4j
@Api(value = "用户管理", description = "用户管理")
public class UserController extends BaseController{
    /**
     * 注册用户 默认开启白名单
     * @param user
     */
    @PostMapping("/register")
    @ApiOperation(value = "注册用户")
    public UserEntity register(@RequestBody @ApiParam(value = "User") UserEntity user){
        UserEntity userEntity = userJpa.findByUsername(user.getUsername());
        if (userEntity != null) {
            throw new UsernameIsExitedException("用户已经存在");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userJpa.save(user);
    }

    @ApiOperation(value = "查询用户列表")
    @GetMapping("/")
    public Map<String,Object> getUserList(){
        List<UserEntity> users=userJpa.findAll();
        log.info("users: {}", users);
        Map<String,Object> map=new HashMap<>(16);
        return map;        
    }


    @ApiOperation(value = "查询用户权限")
    @GetMapping("/authorities")
    public List<String> authorityList(){
        List<String> authentication = getAuthentication();
        return authentication;
    }
    
}