package com.kobe.mall.dao;

import com.kobe.mall.entity.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    Integer selectIdByOpenId(String openId);
}