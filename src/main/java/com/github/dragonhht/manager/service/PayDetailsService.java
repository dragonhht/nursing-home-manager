package com.github.dragonhht.manager.service;

import com.github.dragonhht.manager.model.PayDetails;
import org.springframework.data.domain.Page;

/**
 * Description.
 * User: huang
 * Date: 2018-10-19
 */
public interface PayDetailsService {
    /**
     * 通过老人编号查询缴费
     * @param id
     * @param pageNum
     * @param limit
     * @return
     */
    Page<PayDetails> findRecordByPerson(int id, int pageNum, int limit);

    /**
     * 通过老人姓名查询缴费
     * @param name
     * @param pageNum
     * @param limit
     * @return
     */
    Page<PayDetails> findRecordByPersonName(String name, int pageNum, int limit);

    /**
     * 通过员工查询缴费
     * @param id
     * @param pageNum
     * @param limit
     * @return
     */
    Page<PayDetails> findRecordByEmployee(int id, int pageNum, int limit);

}
