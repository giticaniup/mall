package com.kobe.mall.utils;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class HttpUtilsTest {

    @Test
    public void httpGet() {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&";
        Map<String, String> argMap = new HashMap<>();
        argMap.put("appid", "test");
        argMap.put("secret", "test");
        argMap.put("js_code", "test");
        argMap.put("grant_type", "authorization_code");
        HttpUtils.httpGet(url, argMap);
    }
}