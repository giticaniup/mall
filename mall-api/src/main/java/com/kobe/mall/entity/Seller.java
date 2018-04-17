package com.kobe.mall.entity;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Date;


/**
 * Seller entity class.
 * @author zhongchengyong
 */
public class Seller implements Serializable {

    private static final long serialVersionUID = 9031472934231922180L;

    /**
     * The seller id.automatic increased.
     */
    private Integer id;

    /**
     * The seller name.
     */
    private String name;

    /**
     * The seller desc.
     */
    private String description;

    /**
     * The category seller belongs.
     */
    private String category;

    /**
     * Country.
     */
    private String country;

    /**
     * Province.
     */
    private String province;

    /**
     * City.
     */
    private String city;

    /**
     * Seller certify or not
     */
    private Boolean certify;

    /**
     * Seller forward count.
     */
    private Long promotionCount;

    private Date createTime;

    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getCertify() {
        return certify;
    }

    public void setCertify(Boolean certify) {
        this.certify = certify;
    }

    public Long getPromotionCount() {
        return promotionCount;
    }

    public void setPromotionCount(Long promotionCount) {
        this.promotionCount = promotionCount;
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
                .add("id", id)
                .add("name", name)
                .add("description", description)
                .add("category", category)
                .add("country", country)
                .add("province", province)
                .add("city", city)
                .add("certify", certify)
                .add("promotionCount", promotionCount)
                .add("createTime", createTime)
                .add("modifyTime", modifyTime)
                .toString();
    }
}