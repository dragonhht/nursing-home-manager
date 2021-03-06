package com.github.dragonhht.manager.repository;

import com.github.dragonhht.manager.model.NuresHome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Description.
 * User: huang
 * Date: 2018-10-11
 */
@Repository
@RepositoryRestResource(path = "nuresHome")
public interface NuresHomeRepository extends JpaRepository<NuresHome, Integer> {
}
