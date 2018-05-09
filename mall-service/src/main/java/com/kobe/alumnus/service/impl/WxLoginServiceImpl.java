package com.kobe.alumnus.service.impl;

import com.google.gson.Gson;
import com.kobe.alumnus.arg.LoginArg;
import com.kobe.alumnus.common.utils.DESUtils;
import com.kobe.alumnus.common.utils.JedisUtils;
import com.kobe.alumnus.config.ConfigBean;
import com.kobe.alumnus.constants.WXConstant;
import com.kobe.alumnus.dao.UserMapper;
import com.kobe.alumnus.entity.User;
import com.kobe.alumnus.result.LoginResult;
import com.kobe.alumnus.result.WXResponse;
import com.kobe.alumnus.service.IWxLoginService;
import com.kobe.alumnus.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微信登陆服务实现类
 * Note：Do not force user to fill in user info.
 *
 * @author zhongchengyong
 */
@Service("loginService")
public class WxLoginServiceImpl implements IWxLoginService {

    private static final Logger logger = LoggerFactory.getLogger(WxLoginServiceImpl.class);

    private static int MINUS_TIME = 120;

    @Value("${login.url}")
    private String loginUrl;

    @Autowired
    private ConfigBean configBean;

    @Autowired
    private UserMapper userMapper;

    @Override
    public LoginResult code2OpenId(LoginArg arg) {

        Map<String, String> argMap = new HashMap<>(4);
        System.out.println(configBean.getAppId());
        System.out.println(configBean.getAppSecret());
        argMap.put("appid", configBean.getAppId());
        argMap.put("secret", configBean.getAppSecret());
        argMap.put("js_code", arg.getJsCode());
        argMap.put("grant_type", WXConstant.GRANT_TYPE);

        String ret = HttpUtils.httpGet(loginUrl, argMap);
        WXResponse response = new Gson().fromJson(ret, WXResponse.class);
        String openId = response.getOpenid();
        Integer id = userMapper.selectIdByOpenId(openId);
        if (id == null) {
            //Didn't bind account
            User user = new User(openId);
            userMapper.insertSelective(user);
            id = user.getId();
        }
        //Refresh expires_in
        JedisUtils.setValueAndEx(openId, response.getSession_key(), response.getExpires_in());

        var idList = List.of(String.valueOf(id), openId);
        String token = DESUtils.getEncryptString(String.join("+", idList));
        return new LoginResult(token, response.getExpires_in() - MINUS_TIME);
    }

    @Override
    public void test(String token) {
        logger.info("Check token method, token={}", token);
    }
}
