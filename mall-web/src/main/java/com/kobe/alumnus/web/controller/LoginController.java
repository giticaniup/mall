package com.kobe.alumnus.web.controller;

import com.kobe.alumnus.arg.LoginArg;
import com.kobe.alumnus.arg.TestArg;
import com.kobe.alumnus.common.code.ErrorCode;
import com.kobe.alumnus.common.exception.BizException;
import com.kobe.alumnus.common.result.BaseResult;
import com.kobe.alumnus.common.result.Result;
import com.kobe.alumnus.result.LoginResult;
import com.kobe.alumnus.service.IWxLoginService;
import com.kobe.alumnus.web.anotaions.ValidToken;
import com.kobe.alumnus.web.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登陆controller
 *
 * @author zhongchengyong
 */
@RestController
@RequestMapping("/api")
public class LoginController extends BaseController {

    @Autowired
    private IWxLoginService loginService;

    @PostMapping("/code2session")
    @ResponseBody
    public BaseResult<LoginResult> code2Id(@RequestBody LoginArg loginArg) {
        checkParamsNotBlank(loginArg.getGrantType());
        return new BaseResult<>(loginService.code2OpenId(loginArg));
    }

    @PostMapping("/test")
    @ResponseBody
    @ValidToken
    public Result test(@RequestBody TestArg testArg) {
        logger.info(testArg.getName());
        loginService.test(testArg.getToken());
        throw new BizException(ErrorCode.OK, "测试成功");
    }
}
