package com.github.dragonhht.manager.controller;

import com.github.dragonhht.manager.controller.base.BaseController;
import com.github.dragonhht.manager.model.Employee;
import com.github.dragonhht.manager.model.Role;
import com.github.dragonhht.manager.params.Code;
import com.github.dragonhht.manager.service.EmployeeService;
import com.github.dragonhht.manager.util.PasswordUtil;
import com.github.dragonhht.manager.util.ReturnDataUtils;
import com.github.dragonhht.manager.vo.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

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

    /**
     * 保存员工信息.
     * @param family
     * @return
     * @throws Exception
     */
    @Override
    @PostMapping
    public ReturnData<Employee> save(@RequestBody Employee family) throws Exception {
        PasswordUtil util = PasswordUtil.getInstance();
        family.setPassword(util.encryption(family.getPassword()));
        Role role = new Role("2");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        family.setRoles(roles);
        Employee data = employeeService.save(family);
        return ReturnDataUtils.returnDate(Code.SUCCESS, data);
    }

    /**
     * 根据姓名查询员工。
     * @param name
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/select/by/name")
    public Page<Employee> findBedRecordByBed(String name,
                                             @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                             @RequestParam(name = "size", defaultValue = "0", required = false) int size) {
        return employeeService.getEmpployeeByName(name, page, size);
    }

}
