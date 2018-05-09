package com.kobe.alumnus.result;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * 系统返回结果
 *
 * @author zhongchengyong
 */
public class LoginResult implements Serializable {

    private static final long serialVersionUID = -5154452326311778489L;
    /**
     * Token
     */
    private String token;

    /**
     * 超时时间
     */
    private int expiresIn;


    public LoginResult(String token, int expiresIn) {
        this.token = token;
        this.expiresIn = expiresIn;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("expiresIn", expiresIn)
                .add("token", token)
                .toString();
    }
}
