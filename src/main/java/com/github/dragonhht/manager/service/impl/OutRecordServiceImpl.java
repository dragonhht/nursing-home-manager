package com.github.dragonhht.manager.service.impl;

import com.github.dragonhht.manager.model.OutingRecord;
import com.github.dragonhht.manager.repository.OutRecordRepository;
import com.github.dragonhht.manager.service.OutRecordService;
import com.github.dragonhht.manager.service.base.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Description.
 * User: huang
 * Date: 2018-10-19
 */
@Service
public class OutRecordServiceImpl extends BaseServiceImp<OutingRecord, Integer> implements OutRecordService {

    @Autowired
    private OutRecordRepository outRecordRepository;

    @Override
    public Page<OutingRecord> findRecordByPerson(int id, int pageNum, int limit) {
        if (limit == 0) {
            limit = DEFAULT_PAGE_SIZE;
        }
        Pageable pageable = new PageRequest(pageNum, limit);
        Page<OutingRecord> forms = outRecordRepository.findRecordByPerson(id, pageable);
        return forms;
    }
}
