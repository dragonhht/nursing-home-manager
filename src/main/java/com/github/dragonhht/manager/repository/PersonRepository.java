package com.github.dragonhht.manager.repository;

import com.github.dragonhht.manager.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Description.
 * User: huang
 * Date: 18-9-16
 */
@RepositoryRestResource(path = "person")
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
