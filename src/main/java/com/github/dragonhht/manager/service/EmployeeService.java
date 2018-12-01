package com.github.dragonhht.manager.service;

import com.github.dragonhht.manager.model.Employee;
import com.github.dragonhht.manager.service.base.BaseService;
import org.springframework.data.domain.Page;

/**
 * Description.
 * User: huang
 * Date: 2018-10-24
 */
public interface EmployeeService extends BaseService<Employee, Integer> {
    /**
     * 根据姓名查询员工。
     * @param name
     * @param pageNum
     * @param size
     * @return
     */
    Page<Employee> getEmpployeeByName(String name, int pageNum, int size);
}
