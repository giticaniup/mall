package com.kobe.mall.web.controller;

import com.kobe.mall.arg.LoginArg;
import com.kobe.mall.common.code.ErrorCode;
import com.kobe.mall.common.exception.BizException;
import com.kobe.mall.common.result.BaseResult;
import com.kobe.mall.common.result.Result;
import com.kobe.mall.result.LoginResult;
import com.kobe.mall.service.IWxLoginService;
import com.kobe.mall.web.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/test")
    @ResponseBody
    public Result test(String token) {
        loginService.test(token);
        throw new BizException(ErrorCode.OK, "测试成功");
    }
}
