package com.kobe.alumnus.service.impl;

import com.kobe.alumnus.dao.UserMapper;
import com.kobe.alumnus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户Service实现类。
 * @author zhongchengyong
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer getIdByOpenId(String openId) {
        return userMapper.selectIdByOpenId(openId);
    }

    @Override
    public String test() {
        return null;
    }
}
