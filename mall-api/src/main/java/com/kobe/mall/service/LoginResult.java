package com.kobe.mall.service;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * 微信登陆返回结果
 * @author zhongchengyong
 */
public class LoginResult implements Serializable {

    private static final long serialVersionUID = -5154452326311778489L;

    /**
     * 用户唯一标识
     */
    private String openid;

    /**
     * 会话密钥
     */
    private String session_key;

    /**
     * 用户在开放平台的唯一标识
     */
    private String unionid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("openid", openid)
                .add("session_key", session_key)
                .add("unionid", unionid)
                .toString();
    }
}
