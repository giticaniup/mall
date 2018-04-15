package com.kobe.mall.service;

import com.kobe.mall.entity.Seller;

/**
 * Seller service.
 * @author zhongchengyong
 */
public interface ISellerService {

    /**
     * Register seller on platform.
     * @param seller seller info.
     * @return seller id.
     */
    int registerSeller(Seller seller);

    /**
     * Get seller info by seller id.
     * @param id seller id.
     * @return Seller info.
     */
    Seller getSellerInfo(int id);

    /**
     * Delete seller info by id.
     * @param id Seller id.
     * @return Affect rows.
     */
    int deleteSellerById(int id);
}
