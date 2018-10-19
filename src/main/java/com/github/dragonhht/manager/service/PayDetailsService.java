package com.github.dragonhht.manager.service;

import com.github.dragonhht.manager.model.PayDetails;
import org.springframework.data.domain.Page;

/**
 * Description.
 * User: huang
 * Date: 2018-10-19
 */
public interface PayDetailsService {

    Page<PayDetails> findRecordByPerson(int id, int pageNum, int limit);

}
