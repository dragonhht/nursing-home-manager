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

    Person savePersonByApply(int id) throws Exception;

    Page<ApplyForm> findApplyFormsByStatus(int pageNum, int limit, FormStatus status);

    boolean updateStatus(FormStatus status, int id);

    Page<ApplyForm> findApplyFormsByFamilyId(int id, int pageNum, int limit);

}
