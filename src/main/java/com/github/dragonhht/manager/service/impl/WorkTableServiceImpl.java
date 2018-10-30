package com.github.dragonhht.manager.service.impl;

import com.github.dragonhht.manager.model.WorkTable;
import com.github.dragonhht.manager.repository.WorkTableRepository;
import com.github.dragonhht.manager.service.WorkTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description.
 * User: huang
 * Date: 2018-10-24
 */
@Service
public class WorkTableServiceImpl implements WorkTableService {

    @Autowired
    private WorkTableRepository workTableRepository;

    private final static int ID = 1;

    @Override
    public int save(WorkTable workTable) {
        workTable.setId(ID);
        WorkTable table = workTableRepository.save(workTable);
        return table.getId();
    }

    @Override
    public String getMsg() {
        WorkTable workTable = workTableRepository.getOne(ID);
        return workTable.getFile();
    }


}
