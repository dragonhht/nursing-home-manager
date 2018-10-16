package com.github.dragonhht.manager.service;

import com.github.dragonhht.manager.model.NursRecord;
import org.springframework.data.domain.Page;

/**
 * Description.
 * User: huang
 * Date: 18-10-17
 */
public interface NursRecordService {

    Page<NursRecord> findLogRecordByProject(int id, int pageNum, int limit);

    Page<NursRecord> findLogRecordByPerson(int id, int pageNum, int limit);
}
