package com.github.dragonhht.manager.service.impl;

import com.github.dragonhht.manager.model.NursRecord;
import com.github.dragonhht.manager.repository.NursRecordRepository;
import com.github.dragonhht.manager.service.NursRecordService;
import com.github.dragonhht.manager.service.base.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Description.
 * User: huang
 * Date: 18-10-17
 */
@Service
public class NursRecordServiceImpl extends BaseServiceImp<NursRecord, Integer> implements NursRecordService {

    @Autowired
    private NursRecordRepository nursRecordRepository;


    @Override
    public Page<NursRecord> findRecordByProject(int id, int pageNum, int limit) {
        if (limit == 0) {
            limit = DEFAULT_PAGE_SIZE;
        }
        Pageable pageable = new PageRequest(pageNum, limit);
        Page<NursRecord> forms = nursRecordRepository.findNursRecordByNures(id, pageable);
        return forms;
    }

    @Override
    public Page<NursRecord> findRecordByPerson(int id, int pageNum, int limit) {
        if (limit == 0) {
            limit = DEFAULT_PAGE_SIZE;
        }
        Pageable pageable = new PageRequest(pageNum, limit);
        Page<NursRecord> forms = nursRecordRepository.findNursRecordByPerson(id, pageable);
        return forms;
    }

    @Override
    public Page<NursRecord> findRecordByEmployee(int id, int pageNum, int limit) {
        if (limit == 0) {
            limit = DEFAULT_PAGE_SIZE;
        }
        Pageable pageable = new PageRequest(pageNum, limit);
        Page<NursRecord> forms = nursRecordRepository.findNursRecordByEmployee(id, pageable);
        return forms;
    }
}
