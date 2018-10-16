package com.github.dragonhht.manager.repository;

import com.github.dragonhht.manager.model.Perssion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Description.
 * User: huang
 * Date: 18-9-23
 */
@Repository
public interface PerssionRepository extends JpaRepository<Perssion, String> {
}
