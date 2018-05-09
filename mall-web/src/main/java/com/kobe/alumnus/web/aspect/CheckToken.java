package com.kobe.alumnus.web.aspect;

import com.kobe.alumnus.common.code.ErrorCode;
import com.kobe.alumnus.common.exception.BizException;
import com.kobe.alumnus.common.utils.DESUtils;
import com.kobe.alumnus.service.IUserService;
import com.kobe.alumnus.web.anotaions.RequestType;
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

    private static final String TOKEN_ARG = "token";

    @Autowired
    private IUserService userService;

    public void before(JoinPoint point) throws IllegalAccessException {
        boolean tokenFlag = false;
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        ValidToken annotation = methodSignature.getMethod().getAnnotation(ValidToken.class);
        if (annotation != null) {
            RequestType type = annotation.value();
            if (RequestType.GET == type) {
                Object[] args = point.getArgs();
                logger.info("Token arg={}", args[0]);
                tokenFlag = checkTokenStr((String) args[0]);
            } else {
                Object[] args = point.getArgs();
                logger.info("Token args={}", args);
                for (Object arg : args) {
                    tokenFlag = checkToken(arg.getClass(), arg);
                }
            }
            if (!tokenFlag) {
                throw new BizException(ErrorCode.PARAM_ERROR, "请求参数未包含token。");
            }
        }
    }

    /**
     * 递归查找token field并校验
     *
     * @param clazz 类型
     * @param arg   参数
     * @return token是否有效
     * @throws IllegalAccessException 访问异常
     */
    private boolean checkToken(Class<?> clazz, Object arg) throws IllegalAccessException {
        boolean flag;
        if (clazz == null || clazz == Object.class) {
            return false;
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (TOKEN_ARG.equals(field.getName())) {
                String tokenStr = (String) field.get(arg);
                return checkTokenStr(tokenStr);
            } else {
                flag = checkToken(clazz.getSuperclass(), arg);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkTokenStr(String tokenStr) {
        String tokenArg = DESUtils.getDecryptString(tokenStr);
        String[] ids = tokenArg.split("\\+");
        Integer id = userService.getIdByOpenId(ids[1]);
        if (id == null) {
            throw new BizException(ErrorCode.USER_NOT_LOGIN, "用户未使用过小程序，请重新执行登陆操作。");
        }
        if (!String.valueOf(id).equals(ids[0])) {
            throw new BizException(ErrorCode.PARAM_ERROR, "Token校验失败，可能存在伪造token，请重新执行登陆操作。");
        }
        return true;
    }
}
