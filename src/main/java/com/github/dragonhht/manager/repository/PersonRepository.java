package com.github.dragonhht.manager.repository;

import com.github.dragonhht.manager.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Description.
 * User: huang
 * Date: 18-9-16
 */
@RepositoryRestResource(path = "person")
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("select p from Person p where p.name = ?1")
    List<Person> getPersonByName(String name);

    @Query("select p from Person p where p.family.id = ?1")
    List<Person> findByFamily(int id);

}
