package com.kobe.mall.service.impl;

import com.kobe.mall.entity.Seller;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-dubbo.xml")
public class SellerServiceImplTest {

    private static int insertId;

    @Autowired
    private SellerServiceImpl sellerService;

    @Test
    public void registerSeller() {
        Seller seller = new Seller();
        seller.setName("kobe");
        insertId = sellerService.registerSeller(seller);
    }

    @Test
    public void getSellerInfo() {
        Seller seller = sellerService.getSellerInfo(insertId);
        Assert.assertEquals("kobe", seller.getName());
    }

    @Test
    public void deleteSeller() {
        sellerService.deleteSellerById(insertId);
    }
}