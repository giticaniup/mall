package com.kobe.alumnus.dao;

import com.kobe.alumnus.entity.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    Integer selectIdByOpenId(String openId);
}