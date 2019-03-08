package com.joey.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author EDZ
 * @create 2019-03-08 14:45
 * @desc CallHelloController
 */
@RestController
public class CallHelloController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/call")
    public String call(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("ConsulProducer");
        System.out.println("服务地址"+serviceInstance.getUri());
        System.out.println("服务名称"+serviceInstance.getServiceId());
        String callServiceResult = new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/hello", String.class);
        System.out.println(callServiceResult);
        return callServiceResult;
    }
}
