package com.github.dragonhht.manager.service;

import com.github.dragonhht.manager.model.OutingRecord;
import org.springframework.data.domain.Page;

/**
 * Description.
 * User: huang
 * Date: 2018-10-19
 */
public interface OutRecordService {
    /**
     * 通过老人查询外出记录
     * @param id
     * @param pageNum
     * @param limit
     * @return
     */
    Page<OutingRecord> findRecordByPerson(int id, int pageNum, int limit);

    /**
     * 通过员工查询外出记录
     * @param id
     * @param pageNum
     * @param limit
     * @return
     */
    Page<OutingRecord> findRecordByEmployee(int id, int pageNum, int limit);

}
