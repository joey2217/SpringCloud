package com.joey.user.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Joey
 * @create 2019-01-27 21:44
 * @desc HelloController
 */
@RestController
public class Hello {

    @ApiOperation(value = "Hello Swagger" , notes = "Hello Swagger note")
    @GetMapping("/hello")
    public String hello(){
        return  "Hello";
    }
}
