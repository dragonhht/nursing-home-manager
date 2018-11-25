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

    Page<BedRecord> findBedRecordByBed(String id, int pageNum, int limit);
    boolean updateStatus(FormStatus status, int id);
}
