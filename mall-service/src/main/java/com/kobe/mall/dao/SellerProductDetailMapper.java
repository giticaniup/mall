package com.kobe.mall.dao;

import com.kobe.mall.entity.SellerProductDetail;

public interface SellerProductDetailMapper {
    int insert(SellerProductDetail record);

    int insertSelective(SellerProductDetail record);
}