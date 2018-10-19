package com.github.dragonhht.manager.service;

import com.github.dragonhht.manager.model.OutingRecord;
import org.springframework.data.domain.Page;

/**
 * Description.
 * User: huang
 * Date: 2018-10-19
 */
public interface OutRecordService {

    Page<OutingRecord> findRecordByPerson(int id, int pageNum, int limit);

}
