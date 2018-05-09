package com.kobe.alumnus.arg;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * 需要带token的参数的公共父类。
 *
 * @author zhongchengyong
 */
public class BaseArg implements Serializable {

    private static final long serialVersionUID = -7422081926745523722L;

    /**
     * 参数中的token
     */
    protected String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("token", token)
                .toString();
    }
}
