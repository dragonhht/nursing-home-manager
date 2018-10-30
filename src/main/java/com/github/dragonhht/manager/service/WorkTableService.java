package com.github.dragonhht.manager.service;

import com.github.dragonhht.manager.model.WorkTable;

/**
 * Description.
 * User: huang
 * Date: 2018-10-24
 */
public interface WorkTableService {

    int save(WorkTable workTable);

    String getMsg();

}
