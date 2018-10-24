package com.github.dragonhht.manager.controller;

import com.github.dragonhht.manager.controller.base.BaseController;
import com.github.dragonhht.manager.model.Employee;
import com.github.dragonhht.manager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
