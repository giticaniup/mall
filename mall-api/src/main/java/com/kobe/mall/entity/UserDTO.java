package com.kobe.mall.entity;

import com.google.common.base.MoreObjects;

public class UserDTO {

    /**
     * Open id
     */
    private String openId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("openId", openId)
                .toString();
    }
}
