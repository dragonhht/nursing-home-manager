package com.github.dragonhht.manager.controller;

import com.github.dragonhht.manager.params.Code;
import com.github.dragonhht.manager.util.ReturnDataUtils;
import com.github.dragonhht.manager.vo.ReturnData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description.
 * User: huang
 * Date: 18-9-21
 */
@RestController
@RequestMapping("/common")
public class CommonController {

    @GetMapping("/notLogin")
    public ReturnData<String> notLogin() {
        return ReturnDataUtils.returnDate(Code.NOT_LOGIN, "not login");
    }

    @GetMapping("/unauthorize")
    public ReturnData<String> unauthorize() {
        return ReturnDataUtils.returnDate(Code.UNAUTHORIZE, "无权限访问");
    }

}
