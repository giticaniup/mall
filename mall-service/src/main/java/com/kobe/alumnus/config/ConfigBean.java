package com.kobe.alumnus.config;

import com.kobe.alumnus.common.utils.DESUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConfigBean implements InitializingBean {

    @Value("${appid}")
    private String appId;

    @Value("${appSecret}")
    private String appSecret;


    @Override
    public void afterPropertiesSet() {
        this.appSecret = DESUtils.getDecryptString(appSecret);
    }

    public String getAppId() {
        return appId;
    }

    public String getAppSecret() {
        return appSecret;
    }
}
