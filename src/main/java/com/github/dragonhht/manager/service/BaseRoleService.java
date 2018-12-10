package com.github.dragonhht.manager.service;

import com.github.dragonhht.manager.model.BaseRole;

import java.util.Set;

/**
 * Description.
 * User: huang
 * Date: 18-9-28
 */
public interface BaseRoleService {
    /**
     * 通过id查询角色
     * @param id
     * @return
     * @throws Exception
     */
    Set<String> getRolesById(int id) throws Exception;

    BaseRole getByPhone(String Phone);

}
