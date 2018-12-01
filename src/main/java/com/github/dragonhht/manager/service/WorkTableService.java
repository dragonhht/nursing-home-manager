package com.github.dragonhht.manager.service;

import com.github.dragonhht.manager.model.WorkTable;

/**
 * Description.
 * User: huang
 * Date: 2018-10-24
 */
public interface WorkTableService {
    /**
     * 保存值班表
     * @param workTable
     * @return
     */
    int save(WorkTable workTable);

    /**
     * 获取值班表
     * @return
     */
    String getMsg();

}
