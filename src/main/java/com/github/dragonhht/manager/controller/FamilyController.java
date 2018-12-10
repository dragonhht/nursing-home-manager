package com.github.dragonhht.manager.controller;

import com.github.dragonhht.manager.controller.base.BaseController;
import com.github.dragonhht.manager.model.Family;
import com.github.dragonhht.manager.model.Role;
import com.github.dragonhht.manager.params.Code;
import com.github.dragonhht.manager.service.FamilyService;
import com.github.dragonhht.manager.util.PasswordUtil;
import com.github.dragonhht.manager.util.ReturnDataUtils;
import com.github.dragonhht.manager.vo.ReturnData;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/**
 * Description.
 * User: huang
 * Date: 18-9-20
 */
@Api("家属Controller")
@RestController
@RequestMapping("/family")
public class FamilyController extends BaseController<Family, Integer> {

    @Autowired
    private FamilyService familyService;

    /**
     * 保存家属信息.
     * @param family
     * @return
     * @throws Exception
     */
    @Override
    @PostMapping
    public ReturnData<Family> save(@RequestBody Family family) throws Exception {
        PasswordUtil util = PasswordUtil.getInstance();
        family.setPassword(util.encryption(family.getPassword()));
        Role role = new Role("EMPLOYEE");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        family.setRoles(roles);
        Family data = familyService.save(family);
        return ReturnDataUtils.returnDate(Code.SUCCESS, data);
    }

}
