package com.github.dragonhht.manager.service.impl;

import com.github.dragonhht.manager.model.RetreatApply;
import com.github.dragonhht.manager.params.FormStatus;
import com.github.dragonhht.manager.repository.RetreatRepository;
import com.github.dragonhht.manager.service.RetreatService;
import com.github.dragonhht.manager.service.base.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Description.
 * User: huang
 * Date: 18-10-5
 */
@Service
public class RetreatServiceImpl extends BaseServiceImp<RetreatApply, Integer> implements RetreatService {

    @Autowired
    private RetreatRepository retreatRepository;

    @Override
    public Page<RetreatApply> findApplyFormsByStatus(int pageNum, int limit, FormStatus status) {
        if (limit == 0)
            limit = DEFAULT_PAGE_SIZE;
        Pageable pageable = new PageRequest(pageNum, limit);
        Page<RetreatApply> forms = retreatRepository.findRetreatAppliesByStatusIs(status, pageable);
        return forms;
    }

    @Override
    public boolean updateStatus(FormStatus status, int id) {
        boolean ok = false;
        int n = retreatRepository.updateStatus(status, id);
        if (n > 0)
            ok = true;
        return ok;
    }

    @Override
    public Page<RetreatApply> findRecordByPerson(int id, int pageNum, int limit) {
        if (limit == 0) {
            limit = DEFAULT_PAGE_SIZE;
        }
        Pageable pageable = new PageRequest(pageNum, limit);
        Page<RetreatApply> forms = retreatRepository.findRecordByPerson(id, pageable);
        return forms;
    }
}
