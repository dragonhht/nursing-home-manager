package com.github.dragonhht.manager.service;

import com.github.dragonhht.manager.model.NursRecord;
import org.springframework.data.domain.Page;

/**
 * Description.
 * User: huang
 * Date: 18-10-17
 */
public interface NursRecordService {
    /**
     * 通过护理项目查询护理记录
     * @param id
     * @param pageNum
     * @param limit
     * @return
     */
    Page<NursRecord> findRecordByProject(int id, int pageNum, int limit);

    /**
     * 通过老人查询护理记录
     * @param id
     * @param pageNum
     * @param limit
     * @return
     */
    Page<NursRecord> findRecordByPerson(int id, int pageNum, int limit);

    /**
     * 通过员工查询护理记录
     * @param id
     * @param pageNum
     * @param limit
     * @return
     */
    Page<NursRecord> findRecordByEmployee(int id, int pageNum, int limit);
}
