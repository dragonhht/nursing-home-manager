package com.github.dragonhht.manager.service;

import com.github.dragonhht.manager.model.RetreatApply;
import com.github.dragonhht.manager.params.FormStatus;
import org.springframework.data.domain.Page;

/**
 * 退住申请.
 * User: huang
 * Date: 18-10-5
 */
public interface RetreatService {
    /**
     * 通过状态查询申请
     * @param pageNum
     * @param limit
     * @param status
     * @return
     */
    Page<RetreatApply> findApplyFormsByStatus(int pageNum, int limit, FormStatus status);

    /**
     * 更新审核状态
     * @param status
     * @param id
     * @return
     */
    boolean updateStatus(FormStatus status, int id);

    /**
     * 通过老人查询退住申请
     * @param id
     * @param pageNum
     * @param limit
     * @return
     */
    Page<RetreatApply> findRecordByPerson(int id, int pageNum, int limit);

}
