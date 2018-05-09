package com.kobe.alumnus.web.aspect;

import com.kobe.alumnus.common.code.ErrorCode;
import com.kobe.alumnus.common.exception.BizException;
import com.kobe.alumnus.common.utils.DESUtils;
import com.kobe.alumnus.service.IUserService;
import com.kobe.alumnus.web.anotaions.ValidToken;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;


/**
 * @author zhongchengyong
 */
public class CheckToken {

    private static final Logger logger = LoggerFactory.getLogger(CheckToken.class);

    @Autowired
    private IUserService userService;

    public void before(JoinPoint point) throws IllegalAccessException {
        boolean tokenFlag = false;
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        if (methodSignature.getMethod().getAnnotation(ValidToken.class) != null) {
            Object[] args = point.getArgs();
            logger.info("Token args={}", args);
            for(Object arg : args){
                Class<?> clazz = arg.getClass();
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    if ("token".equals(field.getName())) {
                        tokenFlag = true;
                        String tokenStr = (String) field.get(arg);
                        String tokenArg = DESUtils.getDecryptString(tokenStr);
                        String[] ids = tokenArg.split("\\+");
                        Integer id = userService.getIdByOpenId(ids[1]);
                        if (id == null) {
                            throw new BizException(ErrorCode.USER_NOT_LOGIN, "用户未使用过小程序，请重新执行登陆操作。");
                        }
                        if (!String.valueOf(id).equals(ids[0])) {
                            throw new BizException(ErrorCode.PARAM_ERROR, "Token校验失败，可能存在伪造token，请重新执行登陆操作。");
                        }
                        break;
                    }
                }
            }
            if (!tokenFlag) {
                throw new BizException(ErrorCode.PARAM_ERROR, "请求参数未包含token。");
            }
        }
    }
}
