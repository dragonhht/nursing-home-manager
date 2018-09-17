package com.github.dragonhht.manager.repository;

import com.github.dragonhht.manager.model.OutingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Description.
 * User: huang
 * Date: 18-9-16
 */
@RepositoryRestResource(path = "outRecord")
public interface OutRecordRepository extends JpaRepository<OutingRecord, Integer> {
}
