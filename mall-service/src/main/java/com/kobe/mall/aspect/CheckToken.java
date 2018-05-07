package com.kobe.mall.aspect;

import com.kobe.mall.anotaions.ValidToken;
import com.kobe.mall.common.code.ErrorCode;
import com.kobe.mall.common.exception.BizException;
import com.kobe.mall.common.utils.DESUtils;
import com.kobe.mall.dao.UserMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author zhongchengyong
 */
public class CheckToken {

    private static final Logger logger = LoggerFactory.getLogger(CheckToken.class);

    @Autowired
    private UserMapper userMapper;

    public void before(JoinPoint point) {
        logger.info("Check token in aop");
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        if (methodSignature.getMethod().getAnnotation(ValidToken.class) != null) {
            Object[] args = point.getArgs();
            logger.info("Token args={}", args);
            System.out.println("args=" + args);
            String tokenArg = DESUtils.getDecryptString(String.valueOf(args[0]));
            String[] ids = tokenArg.split("\\+");
            Integer id = userMapper.selectIdByOpenId(ids[1]);
            if (id == null) {
                throw new BizException(ErrorCode.USER_NOT_LOGIN, "用户未使用过小程序，请重新执行登陆操作。");
            }
            if (!String.valueOf(id).equals(ids[0])) {
                throw new BizException(ErrorCode.PARAM_ERROR, "Token校验失败，可能存在伪造token，请重新执行登陆操作。");
            }
        }
    }
}
