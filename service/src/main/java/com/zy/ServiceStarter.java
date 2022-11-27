package com.zy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ServiceStarter {
    public static void main(String[] args) {
        log.info("启动类启动");
        SpringApplication.run(ServiceStarter.class, args);
    }
}
