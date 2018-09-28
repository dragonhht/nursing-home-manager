package com.github.dragonhht.manager.service;

import java.util.Set;

/**
 * Description.
 * User: huang
 * Date: 18-9-28
 */
public interface BaseRoleService {

    Set<String> getRolesById(long id) throws Exception;

}
