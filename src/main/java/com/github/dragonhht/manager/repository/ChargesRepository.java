package com.github.dragonhht.manager.repository;

import com.github.dragonhht.manager.model.Charges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Description.
 * User: huang
 * Date: 2018-10-11
 */
@Repository
public interface ChargesRepository extends JpaRepository<Charges, Integer> {
}
