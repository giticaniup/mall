package com.kobe.mall.dao;

import com.kobe.mall.entity.SellerProduct;

public interface SellerProductMapper {
    int insert(SellerProduct record);

    int insertSelective(SellerProduct record);
}