package com.github.dragonhht.manager.repository;

import com.github.dragonhht.manager.model.Bed;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Description.
 * User: huang
 * Date: 18-9-16
 */
@RepositoryRestResource(path = "bed")
public interface BedRepository extends JpaRepository<Bed, String> {

    Page<Bed> findBedsByIsUsed(boolean isUser, Pageable pageable);
}
