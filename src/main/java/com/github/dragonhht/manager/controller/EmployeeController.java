package com.github.dragonhht.manager.controller;

import com.github.dragonhht.manager.controller.base.BaseController;
import com.github.dragonhht.manager.model.Employee;
import com.github.dragonhht.manager.model.Family;
import com.github.dragonhht.manager.params.Code;
import com.github.dragonhht.manager.service.EmployeeService;
import com.github.dragonhht.manager.util.PasswordUtil;
import com.github.dragonhht.manager.util.ReturnDataUtils;
import com.github.dragonhht.manager.vo.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description.
 * User: huang
 * Date: 2018-10-24
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController extends BaseController<Employee, Integer> {

    @Autowired
    private EmployeeService employeeService;

    @Override
    @PostMapping
    public ReturnData<Employee> save(@RequestBody Employee family) throws Exception {
        PasswordUtil util = PasswordUtil.getInstance();
        family.setPassword(util.encryption(family.getPassword()));
        Employee data = employeeService.save(family);
        return ReturnDataUtils.returnDate(Code.SUCCESS, data);
    }

}
