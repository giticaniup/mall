package com.kobe.mall.utils;

import com.kobe.mall.common.code.ErrorCode;
import com.kobe.mall.common.exception.ConnectWXException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ConnectException;
import java.util.Map;

/**
 * Http请求工具类
 * 单例类
 *
 * @author zhongchengyong
 */
public class HttpUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    private static OkHttpClient client;

    private HttpUtils(){
    }

    static {
        client = new OkHttpClient();
    }


    /**
     * Get请求工具类。TODO：考虑超时+返回结果处理等因素
     * @param url url
     * @param argMap 参数Map
     * @return 调用返回结果
     */
    public static String httpGet(String url, Map<String, String> argMap) {
        StringBuilder sb = new StringBuilder();
        argMap.forEach((k, v) -> sb.append(k).append("=").append(v).append("&"));
        String argStr = "?" + sb.substring(0, sb.length() - 1);

        Request request = new Request.Builder().url(url + argStr).build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            logger.error("Execute http get error. url={}, argMap={}, error=", url, argMap);
            throw new ConnectWXException(ErrorCode.SERVICE_UNAVAILABLE, "Connect to wx server error");
        }
        if (response != null && response.body() != null) {
            try {
                //校验结果中是否包含错误码等信息
                return response.body().string();
            } catch (IOException e) {
                logger.error("Response toString() error. url={}, argMap={}, response={}, error=", url, argMap, response);
            }
        }
        return null;
    }
}
