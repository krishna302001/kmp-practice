package com.kmp.spring.example.spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${server.port}")
    private String port;
    @GetMapping("/hello")
    private String getHello() {
        System.out.println("Port is:"+ port);
        return "hello world!";
    }
}
