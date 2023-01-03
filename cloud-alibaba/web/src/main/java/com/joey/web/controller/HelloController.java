package com.joey.web.controller;

import com.joey.web.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Joey
 */
@RestController
public class HelloController {

    @Autowired
    private UserClient userClient;

    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable Integer id) {
        String user = userClient.getUser(id);
        return user + "form web";
    }

    @GetMapping("/")
    public String hello() {
        return "hello :" + userClient.hello();
    }
}
