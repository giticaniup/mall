package com.kobe.alumnus.service;

import com.kobe.alumnus.arg.LoginArg;
import com.kobe.alumnus.result.LoginResult;

/**
 * 微信登陆接口
 * @author zhongchengyong
 */
public interface IWxLoginService {

    /**
     * 微信登陆获取openid等信息
     * @param arg 登陆arg，包含code
     * @return 返回openid、session_key、unionid
     */
    LoginResult code2OpenId(LoginArg arg);

    void test(String token);
}
