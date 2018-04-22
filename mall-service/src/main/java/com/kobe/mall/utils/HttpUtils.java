package com.kobe.mall.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

/**
 * Http请求工具类
 *
 * @author zhongchengyong
 */
public class HttpUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    /**
     * Get请求工具类。TODO：考虑超时等因素
     * @param url url
     * @param argMap 参数Map
     * @return 调用返回结果
     */
    public static String httpGet(String url, Map<String, String> argMap) {
        StringBuilder sb = new StringBuilder();
        argMap.forEach((k, v) -> sb.append(k).append("=").append(v).append("&"));
        String argStr = "?" + sb.substring(0, sb.length() - 1);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url + argStr).build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            logger.error("Execute http get error. url={}, argMap={}, error=", url, argMap);
        }
        if (response != null && response.body() != null) {
            try {
                return response.body().string();
            } catch (IOException e) {
                logger.error("Response toString() error. url={}, argMap={}, response={}, error=", url, argMap, response);
            }
        }
        return null;
    }
}
