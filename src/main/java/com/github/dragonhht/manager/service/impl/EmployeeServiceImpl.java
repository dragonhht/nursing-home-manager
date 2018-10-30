package com.github.dragonhht.manager.service.impl;

import com.github.dragonhht.manager.model.Employee;
import com.github.dragonhht.manager.repository.EmployeeRepository;
import com.github.dragonhht.manager.service.EmployeeService;
import com.github.dragonhht.manager.service.base.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description.
 * User: huang
 * Date: 2018-10-24
 */
@Service
public class EmployeeServiceImpl extends BaseServiceImp<Employee, Integer> implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

}
