package com.github.dragonhht.manager.controller;

import com.github.dragonhht.manager.model.BaseRole;
import com.github.dragonhht.manager.params.Code;
import com.github.dragonhht.manager.service.BaseRoleService;
import com.github.dragonhht.manager.service.FamilyService;
import com.github.dragonhht.manager.util.JWTUtils;
import com.github.dragonhht.manager.util.ReturnDataUtils;
import com.github.dragonhht.manager.vo.ReturnData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * 权限相关.
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

    /**
     * 未登录.
     * @return
     */
    @GetMapping("/notLogin")
    public ReturnData<String> notLogin() {
        return ReturnDataUtils.returnDate(Code.NOT_LOGIN, "not login");
    }

    /**
     * 未授权
     * @return
     */
    @GetMapping("/unauthorize")
    public ReturnData<String> unauthorize() {
        return ReturnDataUtils.returnDate(Code.UNAUTHORIZE, "无权限访问");
    }

    /**
     * 登录.
     * @param userId
     * @param password
     * @param role
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    public ReturnData<String> login(@RequestParam(value = "userId", required = false, defaultValue = "0") int userId, String password,
                                    String role, @RequestParam(value = "phone", required = false) String phone) throws Exception {
        if (phone != null) {
            BaseRole baseRole = baseRoleService.getByPhone(phone);
            if (baseRole != null) {
                userId = baseRole.getId();
            }
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(String.valueOf(userId), password);
        subject.login(usernamePasswordToken);
        long times = System.currentTimeMillis();
        Set<String> roles = baseRoleService.getRolesById(userId);
        String token = jwtUtils.createTocken(String.valueOf(userId), times, password, roles);
        return ReturnDataUtils.returnDate(Code.SUCCESS, token);

    }

}
