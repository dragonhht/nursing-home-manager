package com.github.dragonhht.manager.controller;

import com.github.dragonhht.manager.params.Code;
import com.github.dragonhht.manager.service.BaseRoleService;
import com.github.dragonhht.manager.util.JWTUtils;
import com.github.dragonhht.manager.util.PasswordUtil;
import com.github.dragonhht.manager.util.ReturnDataUtils;
import com.github.dragonhht.manager.vo.ReturnData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Description.
 * User: huang
 * Date: 18-9-21
 */
@RestController
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private BaseRoleService baseRoleService;

    @GetMapping("/notLogin")
    public ReturnData<String> notLogin() {
        return ReturnDataUtils.returnDate(Code.NOT_LOGIN, "not login");
    }

    @GetMapping("/unauthorize")
    public ReturnData<String> unauthorize() {
        return ReturnDataUtils.returnDate(Code.UNAUTHORIZE, "无权限访问");
    }

    @PostMapping("/login")
    public ReturnData<String> login(int userId, String password, String role) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        PasswordUtil util = PasswordUtil.getInstance();
        //password = util.encryption(password);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(String.valueOf(userId), password);
        subject.login(usernamePasswordToken);
        long times = System.currentTimeMillis();
        Set<String> roles = baseRoleService.getRolesById(userId);
        String token = jwtUtils.createTocken(String.valueOf(userId), times, null, roles);
        return ReturnDataUtils.returnDate(Code.SUCCESS, token);

    }

}
