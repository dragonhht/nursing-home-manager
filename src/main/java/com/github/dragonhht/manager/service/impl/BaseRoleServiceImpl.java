package com.github.dragonhht.manager.service.impl;

import com.github.dragonhht.manager.model.BaseRole;
import com.github.dragonhht.manager.repository.BaseRoleRepository;
import com.github.dragonhht.manager.service.BaseRoleService;
import com.github.dragonhht.manager.service.base.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Description.
 * User: huang
 * Date: 18-9-28
 */
@Service
public class BaseRoleServiceImpl extends BaseServiceImp<BaseRole, Long> implements BaseRoleService {

    @Autowired
    private BaseRoleRepository baseRoleRepository;

    @Override
    public Set<String> getRolesById(long id) throws Exception {
        return baseRoleRepository.findRolesById(id);
    }
}
