package com.zy.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "order", url = "http://localhost:8089/order")
public interface OrderService {


    @RequestMapping("/testA")
    public String test();

}
