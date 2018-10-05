package com.github.dragonhht.manager.repository;

import com.github.dragonhht.manager.model.RetreatApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Description.
 * User: huang
 * Date: 18-10-5
 */
@Repository
public interface RetreatRepository extends JpaRepository<RetreatApply, Integer> {
}
