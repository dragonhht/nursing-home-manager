package com.github.dragonhht.manager.service;

import com.github.dragonhht.manager.model.LogRecord;
import org.springframework.data.domain.Page;

/**
 * Description.
 * User: huang
 * Date: 18-10-13
 */
public interface LogRecordService {

    Page<LogRecord> findLogRecordByEmployee(int id, int pageNum, int limit);

    Page<LogRecord> findLogRecordByPerson(int id, int pageNum, int limit);

}
