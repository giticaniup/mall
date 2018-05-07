package com.kobe.mall.result;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * 微信登陆返回结果
 *
 * @author zhongchengyong
 */
public class WXResponse implements Serializable {

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

    /**
     * 超时时间
     */
    private int expires_in;

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

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("openid", openid)
                .add("session_key", session_key)
                .add("unionid", unionid)
                .add("expires_in", expires_in)
                .toString();
    }
}
