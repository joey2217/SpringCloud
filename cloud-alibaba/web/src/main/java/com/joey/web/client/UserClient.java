package com.joey.web.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Joey
 */
@FeignClient(value = "user", path = "/user")
public interface UserClient {

    @GetMapping("/user/{id}")
    String getUser(@PathVariable Integer id);

    @GetMapping("/hello")
    String hello();
}
