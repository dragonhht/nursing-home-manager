package com.github.dragonhht.manager.repository;

import com.github.dragonhht.manager.model.PayDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Description.
 * User: huang
 * Date: 18-9-17
 */
@Repository
@RepositoryRestResource(path = "payDetails")
public interface PayDetailsRepository extends JpaRepository<PayDetails, Integer> {
}
