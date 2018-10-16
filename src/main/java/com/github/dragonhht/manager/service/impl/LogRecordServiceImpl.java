package com.github.dragonhht.manager.service.impl;

import com.github.dragonhht.manager.model.LogRecord;
import com.github.dragonhht.manager.repository.BedRecordRepository;
import com.github.dragonhht.manager.repository.LogRecordRepository;
import com.github.dragonhht.manager.service.LogRecordService;
import com.github.dragonhht.manager.service.base.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Description.
 * User: huang
 * Date: 18-10-13
 */
@Service
public class LogRecordServiceImpl extends BaseServiceImp<LogRecord, Integer> implements LogRecordService {

    @Autowired
    private LogRecordRepository logRecordRepository;

    @Override
    public Page<LogRecord> findLogRecordByEmployee(int id, int pageNum, int limit) {
        if (limit == 0)
            limit = DEFAULT_PAGE_SIZE;
        Pageable pageable = new PageRequest(pageNum, limit);
        Page<LogRecord> forms = logRecordRepository.findLogRecordByEmployee(id, pageable);
        return forms;
    }

    @Override
    public Page<LogRecord> findLogRecordByPerson(int id, int pageNum, int limit) {
        if (limit == 0)
            limit = DEFAULT_PAGE_SIZE;
        Pageable pageable = new PageRequest(pageNum, limit);
        Page<LogRecord> forms = logRecordRepository.findLogRecordByPerson(id, pageable);
        return forms;
    }
}
