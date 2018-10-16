package com.github.dragonhht.manager.repository;

import com.github.dragonhht.manager.model.NursRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Description.
 * User: huang
 * Date: 18-9-16
 */
@RepositoryRestResource(path = "nursRecord")
public interface NursRecordRepository extends JpaRepository<NursRecord, Integer> {

    @Query("select n from NursRecord n where n.project.id = ?1")
    Page<NursRecord> findNursRecordByNures(int id, Pageable pageable);

    @Query("select n from NursRecord n where n.person.id = ?1")
    Page<NursRecord> findNursRecordByPerson(int id, Pageable pageable);

}
