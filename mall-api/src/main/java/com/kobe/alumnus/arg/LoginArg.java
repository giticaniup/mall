package com.kobe.alumnus.arg;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * 微信登陆接口参数
 * @author zhongchengyong
 */
public class LoginArg implements Serializable {

    private static final long serialVersionUID = 7189912116144099499L;

    /**
     * App id.
     */
    private String appid;

    /**
     * App secret.
     */
    private String secret;

    /**
     * 登陆时获取的code.
     */
    private String jsCode;

    /**
     * 授权类型，默认值为authorization_code
     */
    private String grantType = "authorization_code";

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getJsCode() {
        return jsCode;
    }

    public void setJsCode(String jsCode) {
        this.jsCode = jsCode;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("appid", appid)
                .add("secret", secret)
                .add("jsCode", jsCode)
                .add("grantType", grantType)
                .toString();
    }
}
