package com.github.dragonhht.manager.repository;

import com.github.dragonhht.manager.model.RetreatApply;
import com.github.dragonhht.manager.params.FormStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Description.
 * User: huang
 * Date: 18-10-5
 */
@Repository
@RepositoryRestResource(path = "retreat")
public interface RetreatRepository extends JpaRepository<RetreatApply, Integer> {

    Page<RetreatApply> findRetreatAppliesByStatusIs(FormStatus status, Pageable pageable);

    @Modifying
    @Query("update RetreatApply set status = ?1 where id = ?2 ")
    int updateStatus(FormStatus status, int id);

    @Query("select n from RetreatApply n where n.person.id = ?1")
    Page<RetreatApply> findRecordByPerson(int id, Pageable pageable);

}
