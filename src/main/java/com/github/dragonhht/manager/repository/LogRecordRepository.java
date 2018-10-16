package com.github.dragonhht.manager.repository;

import com.github.dragonhht.manager.model.LogRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Description.
 * User: huang
 * Date: 18-10-13
 */
@Repository
@RepositoryRestResource(path = "logRecord")
public interface LogRecordRepository extends JpaRepository<LogRecord, Integer> {

    @Query("select l from LogRecord l where l.employee.id = ?1")
    Page<LogRecord> findLogRecordByEmployee(int id, Pageable pageable);

    @Query("select l from LogRecord l where l.person.id = ?1")
    Page<LogRecord> findLogRecordByPerson(int id, Pageable pageable);
}
