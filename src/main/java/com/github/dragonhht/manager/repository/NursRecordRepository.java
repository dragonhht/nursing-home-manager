package com.github.dragonhht.manager.repository;

import com.github.dragonhht.manager.model.NursRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Description.
 * User: huang
 * Date: 18-9-16
 */
@RepositoryRestResource(path = "nursRecord")
public interface NursRecordRepository extends JpaRepository<NursRecord, Integer> {
}
