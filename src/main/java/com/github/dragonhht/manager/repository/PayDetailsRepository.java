package com.github.dragonhht.manager.repository;

import com.github.dragonhht.manager.model.PayDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Description.
 * User: huang
 * Date: 18-9-17
 */
@Repository
@RepositoryRestResource(path = "payDetails")
public interface PayDetailsRepository extends JpaRepository<PayDetails, Integer> {

    @Query("select n from PayDetails n where n.person.id = ?1")
    Page<PayDetails> findRecordByPerson(int id, Pageable pageable);

    @Query("select n from PayDetails n where n.person.name = ?1")
    Page<PayDetails> findRecordByPersonName(String name, Pageable pageable);

    @Query("select n from PayDetails n where n.employee.id = ?1")
    Page<PayDetails> findRecordByEmployee(int id, Pageable pageable);

}
