package com.github.dragonhht.manager.service.impl;

import com.github.dragonhht.manager.model.Person;
import com.github.dragonhht.manager.repository.PersonRepository;
import com.github.dragonhht.manager.service.PersonService;
import com.github.dragonhht.manager.service.base.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description.
 * User: huang
 * Date: 18-9-21
 */
@Service
public class PersonServiceImpl extends BaseServiceImp<Person, Integer> implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getPersonByName(String name) {
        return personRepository.getPersonByName(name);
    }
}
