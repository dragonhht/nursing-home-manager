package com.github.dragonhht.manager.repository;

import com.github.dragonhht.manager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Description.
 * User: huang
 * Date: 18-9-22
 */
@Repository
@RepositoryRestResource(path = "employee")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
