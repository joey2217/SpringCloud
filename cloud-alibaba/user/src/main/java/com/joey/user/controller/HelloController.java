package com.joey.user.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author Joey
 */
@RestController
public class HelloController {


    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        return "Hello User " + string;
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable Integer id) {
        return "user:" + id;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello from user";
    }
}
