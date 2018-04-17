package com.kobe.mall.entity;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * Seller product class.
 * @author zhongchengyong
 */
public class SellerProduct implements Serializable {

    private static final long serialVersionUID = -6218019011513332605L;

    /**
     * The product id.
     */
    private Integer productId;

    /**
     * The sellerId, which defined by {@link com.kobe.mall.entity.Seller}.
     */
    private Integer sellerId;

    /**
     * The product brand.
     */
    private String brand;

    /**
     * The product title, show in product list.
     */
    private String productTitle;

    /**
     * The product description, show in product list.
     */
    private String productDesc;

    /**
     * The original price.
     */
    private BigDecimal salePrice;

    private Integer saleCount;

    private String photoUrl;

    private Integer forwardCount;

    private Date createTime;

    private Date modifyTime;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Integer getForwardCount() {
        return forwardCount;
    }

    public void setForwardCount(Integer forwardCount) {
        this.forwardCount = forwardCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("productId", productId)
                .add("sellerId", sellerId)
                .add("brand", brand)
                .add("productTitle", productTitle)
                .add("productDesc", productDesc)
                .add("salePrice", salePrice)
                .add("saleCount", saleCount)
                .add("photoUrl", photoUrl)
                .add("forwardCount", forwardCount)
                .add("createTime", createTime)
                .add("modifyTime", modifyTime)
                .toString();
    }
}