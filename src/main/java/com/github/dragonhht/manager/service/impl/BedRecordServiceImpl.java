package com.github.dragonhht.manager.service.impl;

import com.github.dragonhht.manager.model.BedRecord;
import com.github.dragonhht.manager.params.FormStatus;
import com.github.dragonhht.manager.repository.BedRecordRepository;
import com.github.dragonhht.manager.service.BedRecordService;
import com.github.dragonhht.manager.service.base.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description.
 * User: huang
 * Date: 18-9-21
 */
@Service
public class BedRecordServiceImpl extends BaseServiceImp<BedRecord, Integer> implements BedRecordService {

    @Autowired
    private BedRecordRepository bedRecordRepository;

    @Override
    public Page<BedRecord> findBedRecordByBed(String id, int pageNum, int limit) {
        if (limit == 0)
            limit = DEFAULT_PAGE_SIZE;
        Pageable pageable = new PageRequest(pageNum, limit);
        Page<BedRecord> forms = bedRecordRepository.findBedRecordByBed(id, pageable);
        return forms;
    }

    @Transactional
    @Override
    public boolean updateStatus(FormStatus status, int id) {
        boolean ok = false;
        int n = bedRecordRepository.updateStatus(status, id);
        if (n > 0) {
            ok = true;
        }
        return ok;
    }
}
