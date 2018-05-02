package com.kobe.mall.common.result;

import com.google.common.base.MoreObjects;
import com.kobe.mall.common.code.ErrorCode;

import java.io.Serializable;

/**
 * Result类
 *
 * @author zhongcy
 * @date 16-11-3
 */
public class Result implements Serializable {

    private static final long serialVersionUID = 8955661953254186351L;


    /**
     * 错误码，默认为0
     */
    int errorCode = ErrorCode.OK;

    /**
     * 错误信息
     */
    String errorMsg = "success";


    public Result() {
    }

    public Result(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("errorCode", errorCode)
                .add("errorMsg", errorMsg)
                .toString();
    }
}
