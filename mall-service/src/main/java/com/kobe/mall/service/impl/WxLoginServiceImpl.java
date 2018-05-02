package com.kobe.mall.service.impl;

import com.google.gson.Gson;
import com.kobe.mall.arg.LoginArg;
import com.kobe.mall.constants.WXConstant;
import com.kobe.mall.service.IWxLoginService;
import com.kobe.mall.result.LoginResult;
import com.kobe.mall.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信登陆服务实现类
 * @author zhongchengyong
 */
public class WxLoginServiceImpl implements IWxLoginService {


    @Value("login.url")
    private String loginUrl;

    @Override
    public LoginResult code2OpenId(LoginArg arg) {

        Map<String, String> argMap = new HashMap<>(4);
        argMap.put("appid", arg.getAppid());
        argMap.put("secret", arg.getSecret());
        argMap.put("js_code", arg.getJsCode());
        argMap.put("grant_type", WXConstant.GRANT_TYPE);

        String ret = HttpUtils.httpGet(loginUrl, argMap);
        return new Gson().fromJson(ret, LoginResult.class);
    }
}
