package com.github.dragonhht.manager.repository;

import com.github.dragonhht.manager.model.BedRecord;
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
@RepositoryRestResource(path = "bedRecord")
public interface BedRecordRepository extends JpaRepository<BedRecord, Integer> {

    @Query("select b from BedRecord b where b.bed.id = ?1")
    Page<BedRecord> findBedRecordByBed(String id, Pageable pageable);

}
