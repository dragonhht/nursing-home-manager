package com.github.dragonhht.manager.repository;

import com.github.dragonhht.manager.model.LogRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Description.
 * User: huang
 * Date: 18-10-13
 */
@Repository
public interface LogRecordRepository extends JpaRepository<LogRecord, Integer> {
}
