package com.management.department.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ping")
@RefreshScope
public class PingContoller {

    @Value("${spring.boot.message}")
    private String message;


    @GetMapping("/conf-prop-change")
    public String ping() {
        return message;
    }

}
