package com.github.dragonhht.manager.service;

import com.github.dragonhht.manager.model.ApplyForm;
import com.github.dragonhht.manager.model.Person;
import com.github.dragonhht.manager.params.FormStatus;
import org.springframework.data.domain.Page;

/**
 * Description.
 * User: huang
 * Date: 18-9-21
 */
public interface ApplyFormService {

    /**
     * 通过申请保存老人.
     * @param id
     * @return
     * @throws Exception
     */
    Person savePersonByApply(int id) throws Exception;

    /**
     * 通过状态查询申请
     * @param pageNum
     * @param limit
     * @param status
     * @return
     */
    Page<ApplyForm> findApplyFormsByStatus(int pageNum, int limit, FormStatus status);

    /**
     * 更新状态
     * @param status
     * @param id
     * @return
     */
    boolean updateStatus(FormStatus status, int id);

    /**
     * 通过家属查找申请
     * @param id
     * @param pageNum
     * @param limit
     * @return
     */
    Page<ApplyForm> findApplyFormsByFamilyId(int id, int pageNum, int limit);

}
