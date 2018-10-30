package com.github.dragonhht.manager.controller.handler;

import com.github.dragonhht.manager.params.Code;
import com.github.dragonhht.manager.util.ReturnDataUtils;
import com.github.dragonhht.manager.vo.ReturnData;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Controller异常处理.
 * User: huang
 * Date: 18-10-5
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ReturnData handler(Exception e) {
        log.error(e.getMessage());
        e.printStackTrace();
        if (e instanceof UnauthenticatedException) {
            return ReturnDataUtils.returnDate(Code.NOT_LOGIN, "请登录");
        }
        if (e instanceof IncorrectCredentialsException) {
            return ReturnDataUtils.returnDate(Code.FAILED, "密码错误");
        }
        if (e instanceof UnknownAccountException) {
            return ReturnDataUtils.returnDate(Code.FAILED, "登录失败");
        }
        //e.printStackTrace();
        return ReturnDataUtils.returnDate(Code.FAILED, "未知错误");
    }

}
