package com.kobe.mall.entity;


import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Date;

/**
 * The seller product detail class.
 * @author zhongchengyong
 */
public class SellerProductDetail implements Serializable {

    private static final long serialVersionUID = 2976979754623681913L;

    /**
     * The product id.
     */
    private Integer id;

    /**
     * The product details, json format string.
     */
    private String details;

    /**
     * The product photo url, json format string, key is "value".
     */
    private String photoUrl;

    private Date createTime;

    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
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
                .add("details", details)
                .add("photoUrl", photoUrl)
                .add("createTime", createTime)
                .add("modifyTime", modifyTime)
                .toString();
    }
}