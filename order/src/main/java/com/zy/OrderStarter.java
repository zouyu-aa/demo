package com.zy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class OrderStarter {
    public static void main(String[] args) {
        log.info("启动类启动");
        SpringApplication.run(OrderStarter.class, args);
    }
}
