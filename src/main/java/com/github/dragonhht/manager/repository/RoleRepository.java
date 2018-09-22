package com.github.dragonhht.manager.repository;

import com.github.dragonhht.manager.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Description.
 * User: huang
 * Date: 18-9-22
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}
