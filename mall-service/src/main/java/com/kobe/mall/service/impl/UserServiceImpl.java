//package com.kobe.mall.service.impl;
//
//import com.alibaba.dubbo.config.annotation.Service;
//import com.kobe.mall.entity.UserDTO;
//import com.kobe.mall.redis.IRedisService;
//import com.kobe.mall.service.IUserService;
//
//
////@Service
//public class UserServiceImpl extends IRedisService<UserDTO> implements IUserService {
//
//    private static final String USER_REDIS_KEY = "USER_REDIS_KEY";
//
//    @Override
//    protected String getRedisKey() {
//        return USER_REDIS_KEY;
//    }
//
//
//    @Override
//    public String test() {
//        return "hi";
//    }
//}