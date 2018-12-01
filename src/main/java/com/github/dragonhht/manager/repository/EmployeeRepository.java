package com.github.dragonhht.manager.repository;

import com.github.dragonhht.manager.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Description.
 * User: huang
 * Date: 18-9-22
 */
@Repository
@RepositoryRestResource(path = "employee")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("select e from Employee e where e.name = ?1")
    Page<Employee> findByName(String name, Pageable pageable);
}
