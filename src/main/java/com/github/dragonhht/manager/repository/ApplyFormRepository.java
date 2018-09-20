package com.github.dragonhht.manager.repository;

import com.github.dragonhht.manager.model.ApplyForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Description.
 * User: huang
 * Date: 18-9-20
 */
@RepositoryRestResource(path = "applys")
public interface ApplyFormRepository extends JpaRepository<ApplyForm, Integer> {
}