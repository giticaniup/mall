package com.kobe.mall.utils;

import com.kobe.mall.common.utils.DESUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class HttpUtilsTest {

    @Test
    public void httpGet() {
        var list = Arrays.asList("1", "ovRsZ0UR-l189VVFop2QxjUsMwVE");
        System.out.println(DESUtils.getEncryptString(String.join("+", list)));
//        String url = "https://api.weixin.qq.com/sns/jscode2session";
//        Map<String, String> argMap = new HashMap<>();
//        argMap.put("appid", "test");
//        argMap.put("secret", "test");
//        argMap.put("js_code", "test");
//        argMap.put("grant_type", "authorization_code");
//        System.out.println(HttpUtils.httpGet(url, argMap));
    }
}