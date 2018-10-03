package com.github.dragonhht.manager.service;

import com.github.dragonhht.manager.model.Bed;
import org.springframework.data.domain.Page;

/**
 * Description.
 * User: huang
 * Date: 18-9-21
 */
public interface BedService {

    Page<Bed> getBedsByStatus(int pageNum, int size, boolean isUser) throws Exception;

}
