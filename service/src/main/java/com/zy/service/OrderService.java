package com.zy.service;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

//@FeignClient(name = "order", url = "http://localhost:8089/order")
//@FeignClient(name = "order")
@FeignClient(name = "http://127.0.0.1:8089/order")
@Component
public interface OrderService {
    @PostMapping("/testA")
    public String test();
}
