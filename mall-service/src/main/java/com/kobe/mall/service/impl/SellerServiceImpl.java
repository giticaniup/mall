package com.kobe.mall.service.impl;

import com.kobe.mall.dao.SellerMapper;
import com.kobe.mall.entity.Seller;
import com.kobe.mall.service.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Seller service implement class.
 *
 * @author zhongchengyong
 */

@Service("sellerService")
public class SellerServiceImpl implements ISellerService {

    @Autowired
    private SellerMapper sellerMapper;

    @Override
    public int registerSeller(Seller seller) {
        sellerMapper.insertSelective(seller);
        return seller.getId();
    }

    @Override
    public Seller getSellerInfo(int id) {
        return sellerMapper.getSellerById(id);
    }

    @Override
    public int deleteSellerById(int id) {
        return sellerMapper.deleteSellerById(id);
    }
}
