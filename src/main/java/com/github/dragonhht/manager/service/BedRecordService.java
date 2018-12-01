package com.github.dragonhht.manager.service;

import com.github.dragonhht.manager.model.ApplyForm;
import com.github.dragonhht.manager.model.BedRecord;
import com.github.dragonhht.manager.params.FormStatus;
import org.springframework.data.domain.Page;

/**
 * Description.
 * User: huang
 * Date: 18-9-21
 */
public interface BedRecordService {

    /***
     * 通过床位查询床位记录
     * @param id
     * @param pageNum
     * @param limit
     * @return
     */
    Page<BedRecord> findBedRecordByBed(String id, int pageNum, int limit);

    /**
     * 更新审核状态
     * @param status
     * @param id
     * @return
     */
    boolean updateStatus(FormStatus status, int id);
}
