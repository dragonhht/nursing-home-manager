package com.github.dragonhht.manager.service;

import com.github.dragonhht.manager.model.ApplyForm;
import com.github.dragonhht.manager.model.RetreatApply;
import com.github.dragonhht.manager.params.FormStatus;
import org.springframework.data.domain.Page;

/**
 * Description.
 * User: huang
 * Date: 18-10-5
 */
public interface RetreatService {

    Page<RetreatApply> findApplyFormsByStatus(int pageNum, int limit, FormStatus status);

    boolean updateStatus(FormStatus status, int id);

}
