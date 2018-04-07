package com.kobe.mall.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class LoginController {

    @GetMapping("/login")
    @ResponseBody
    public String login() {
        return "hello";
    }

    public static void main(String[] args) {
        SpringApplication.run(LoginController.class, args);
    }
}
