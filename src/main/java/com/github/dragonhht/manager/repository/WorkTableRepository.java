package com.github.dragonhht.manager.repository;

import com.github.dragonhht.manager.model.WorkTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Description.
 * User: huang
 * Date: 2018-10-24
 */
@Repository
public interface WorkTableRepository extends JpaRepository<WorkTable, Integer> {
}
