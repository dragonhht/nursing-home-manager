package com.github.dragonhht.manager.service.impl;

import com.github.dragonhht.manager.model.Employee;
import com.github.dragonhht.manager.repository.EmployeeRepository;
import com.github.dragonhht.manager.service.EmployeeService;
import com.github.dragonhht.manager.service.base.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<Employee> getEmpployeeByName(String name, int pageNum, int size) {
        if (size == 0)
            size = DEFAULT_PAGE_SIZE;
        Pageable pageable = new PageRequest(pageNum, size);
        Page<Employee> forms = employeeRepository.findByName(name, pageable);
        return forms;
    }
}
