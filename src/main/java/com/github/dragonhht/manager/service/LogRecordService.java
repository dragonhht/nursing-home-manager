package com.github.dragonhht.manager.service;

import com.github.dragonhht.manager.model.LogRecord;
import org.springframework.data.domain.Page;

/**
 * Description.
 * User: huang
 * Date: 18-10-13
 */
public interface LogRecordService {

    /**
     * 通过员工查询日志记录
     * @param id
     * @param pageNum
     * @param limit
     * @return
     */
    Page<LogRecord> findLogRecordByEmployee(int id, int pageNum, int limit);

    /**
     * 通过老人查询日志
     * @param id
     * @param pageNum
     * @param limit
     * @return
     */
    Page<LogRecord> findLogRecordByPerson(int id, int pageNum, int limit);

}
