package com.github.dragonhht.manager.service;

import com.github.dragonhht.manager.model.Bed;
import org.springframework.data.domain.Page;

/**
 * Description.
 * User: huang
 * Date: 18-9-21
 */
public interface BedService {
    /**
     * 通过状态获取床位信息
     * @param pageNum
     * @param size
     * @param isUser
     * @return
     * @throws Exception
     */
    Page<Bed> getBedsByStatus(int pageNum, int size, boolean isUser) throws Exception;

}
