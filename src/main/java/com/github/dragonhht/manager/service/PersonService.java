package com.github.dragonhht.manager.service;

import com.github.dragonhht.manager.model.Person;

import java.util.List;

/**
 * Description.
 * User: huang
 * Date: 18-9-21
 */
public interface PersonService {
    /**
     * 通过老人姓名查询老人
     * @param name
     * @return
     */
    List<Person> getPersonByName(String name);

}
