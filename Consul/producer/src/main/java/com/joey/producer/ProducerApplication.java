package com.joey.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author EDZ
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ProducerApplication {

    @GetMapping("/hello")
    public String hello(){
        return  "Hello From ProducerApplication11111";
    }

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

}
