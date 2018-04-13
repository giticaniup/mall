//package com.kobe.mall.web.controller;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.kobe.mall.service.IUserService;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@EnableAutoConfiguration
//@RequestMapping("/api")
//public class LoginController {
//
//    @Reference(url = "dubbo://127.0.0.1:20880")
//    private IUserService iUserService;
//
//    @GetMapping("/login")
//    @ResponseBody
//    public String login() {
//        return iUserService.test();
//    }
//
//}
