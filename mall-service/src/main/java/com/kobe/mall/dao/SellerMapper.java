package com.kobe.mall.dao;

import com.kobe.mall.entity.Seller;

/**
 * @author zhongchengyong
 */
public interface SellerMapper {
    int insert(Seller record);

    int insertSelective(Seller record);

    Seller getSellerById(int id);

    int deleteSellerById(int id);
}