package com.github.dragonhht.manager.service.impl;

import com.github.dragonhht.manager.model.Family;
import com.github.dragonhht.manager.repository.FamilyRepository;
import com.github.dragonhht.manager.service.FamilyService;
import com.github.dragonhht.manager.service.base.BaseServiceImp;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description.
 * User: huang
 * Date: 18-9-20
 */
@Log4j2
@Service
public class FamilyServiceImpl extends BaseServiceImp<Family, Integer> implements FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

}
