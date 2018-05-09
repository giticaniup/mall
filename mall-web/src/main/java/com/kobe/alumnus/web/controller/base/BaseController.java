package com.kobe.alumnus.web.controller.base;

import com.kobe.alumnus.common.code.ErrorCode;
import com.kobe.alumnus.common.exception.BizException;
import com.kobe.alumnus.common.result.Result;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 基本Controller的父类
 * Created by zhongcy on 2016/9/1.
 */
public abstract class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected static final Result SUCCESS = new Result();

    protected static final Result SYSTEM_ERROR = new Result(ErrorCode.SYSTEM_ERROR, "系统错误");

    /**
     * 异常通用处理
     *
     * @param e 异常
     */
    @ExceptionHandler
    @ResponseBody
    public Result exception(Exception e) {
        if (e instanceof BizException) {
            BizException biz = (BizException) e;
            return new Result(biz.getErrorCode(), biz.getErrorDescription());
        }
        if (e instanceof IllegalArgumentException) {
            return new Result(ErrorCode.PARAM_ERROR, e.getLocalizedMessage());
        }
        return SYSTEM_ERROR;
    }

    /**
     * 参数校验方法
     */
    protected void checkParamNotBlank(Object obj, String message) {
        if (null == obj) {
            throw new BizException(ErrorCode.PARAM_ERROR, message);
        }

        if (obj instanceof String && StringUtils.isBlank((String) obj)) {
            throw new BizException(ErrorCode.PARAM_ERROR, message);
        }
    }

    protected void checkParamsNotBlank(Object... objects) {
        for (Object obj : objects) {
            if (null == obj) {
                throw new BizException(ErrorCode.PARAM_ERROR, "参数不能为空");
            }

            if (obj instanceof String && StringUtils.isBlank((String) obj)) {
                throw new BizException(ErrorCode.PARAM_ERROR, "参数不能为空");
            }
        }
    }
}