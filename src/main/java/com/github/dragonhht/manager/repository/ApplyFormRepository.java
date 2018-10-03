package com.github.dragonhht.manager.repository;

import com.github.dragonhht.manager.model.ApplyForm;
import com.github.dragonhht.manager.params.FormStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Description.
 * User: huang
 * Date: 18-9-20
 */
@RepositoryRestResource(path = "applys")
public interface ApplyFormRepository extends JpaRepository<ApplyForm, Integer> {

    //@Query("select a from ApplyForm a where a.status = ?1")
    Page<ApplyForm> findApplyFormByStatusIs(FormStatus status, Pageable pageable);

}
