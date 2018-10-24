package com.github.dragonhht.manager.service.impl;

import com.github.dragonhht.manager.model.PayDetails;
import com.github.dragonhht.manager.repository.PayDetailsRepository;
import com.github.dragonhht.manager.service.PayDetailsService;
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
public class PayDetailsServiceImpl extends BaseServiceImp<PayDetails, Integer> implements PayDetailsService {

    @Autowired
    private PayDetailsRepository payDetailsRepository;

    @Override
    public Page<PayDetails> findRecordByPerson(int id, int pageNum, int limit) {
        if (limit == 0) {
            limit = DEFAULT_PAGE_SIZE;
        }
        Pageable pageable = new PageRequest(pageNum, limit);
        Page<PayDetails> forms = payDetailsRepository.findRecordByPerson(id, pageable);
        return forms;
    }

    @Override
    public Page<PayDetails> findRecordByEmployee(int id, int pageNum, int limit) {
        if (limit == 0) {
            limit = DEFAULT_PAGE_SIZE;
        }
        Pageable pageable = new PageRequest(pageNum, limit);
        Page<PayDetails> forms = payDetailsRepository.findRecordByEmployee(id, pageable);
        return forms;
    }
}
