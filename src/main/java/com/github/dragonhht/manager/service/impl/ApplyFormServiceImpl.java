package com.github.dragonhht.manager.service.impl;

import com.github.dragonhht.manager.model.ApplyForm;
import com.github.dragonhht.manager.model.Person;
import com.github.dragonhht.manager.params.FormStatus;
import com.github.dragonhht.manager.repository.ApplyFormRepository;
import com.github.dragonhht.manager.repository.PersonRepository;
import com.github.dragonhht.manager.service.ApplyFormService;
import com.github.dragonhht.manager.service.base.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Description.
 * User: huang
 * Date: 18-9-21
 */
@Service
public class ApplyFormServiceImpl extends BaseServiceImp<ApplyForm, Integer> implements ApplyFormService {

    @Autowired
    private ApplyFormRepository applyFormRepository;
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person savePersonByApply(int id) throws Exception {
        Optional<ApplyForm> apply = applyFormRepository.findById(id);
        ApplyForm form = apply.get();
        Person person = new Person();
        person.setFamily(form.getFamily());
        person.setSex(form.getSex());
        person.setName(form.getName());
        person.setAge(form.getAge());
        person.setPhysical(form.getPhysical());
        return personRepository.save(person);
    }

    @Override
    public Page<ApplyForm> findApplyFormsByStatus(int pageNum, int limit, FormStatus status) {
        if (limit == 0)
            limit = DEFAULT_PAGE_SIZE;
        Pageable pageable = new PageRequest(pageNum, limit);
        Page<ApplyForm> forms = applyFormRepository.findApplyFormByStatusIs(status, pageable);
        return forms;
    }

    @Override
    public boolean updateStatus(FormStatus status, int id) {
        boolean ok = false;
        int n = applyFormRepository.updateStatus(status, id);
        if (n > 0)
            ok = true;
        return ok;
    }

    @Override
    public Page<ApplyForm> findApplyFormsByFamilyId(int id, int pageNum, int limit) {
        if (limit == 0)
            limit = DEFAULT_PAGE_SIZE;
        Pageable pageable = new PageRequest(pageNum, limit);
        Page<ApplyForm> forms = applyFormRepository.findApplyFormByFamilyId(id, pageable);
        return forms;
    }
}
