package com.github.dragonhht.manager.service.impl;

import com.github.dragonhht.manager.model.Bed;
import com.github.dragonhht.manager.repository.BedRepository;
import com.github.dragonhht.manager.service.BedService;
import com.github.dragonhht.manager.service.base.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Description.
 * User: huang
 * Date: 18-9-21
 */
@Service
public class BedServiceImpl extends BaseServiceImp<Bed, String> implements BedService {

    @Autowired
    private BedRepository bedRepository;

    @Override
    public Page<Bed> getBedsByStatus(int pageNum, int size, boolean isUser) throws Exception {
        if (size == 0)
            size = DEFAULT_PAGE_SIZE;
        Pageable pageable = new PageRequest(pageNum, size);
        Page<Bed> beds = bedRepository.findBedsByIsUsed(isUser, pageable);
        return beds;
    }
}
