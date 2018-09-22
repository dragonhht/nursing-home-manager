package com.github.dragonhht.manager.repository;

import com.github.dragonhht.manager.model.BaseRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Description.
 * User: huang
 * Date: 18-9-22
 */
@Repository
public interface BaseRoleRepository extends JpaRepository<BaseRole, Long> {

    /**
     * 根据用户ID查询密码.
     * @param id
     * @return
     */
    @Query("select password from BaseRole where id = ?1")
    String findPasswordById(long id);

    @Query(nativeQuery = true, value = "select role_id from user_role where user_id = ?1")
    Set<String> findRolesById(long id);
}
