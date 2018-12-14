package com.github.dragonhht.manager.controller;

import com.github.dragonhht.manager.controller.base.BaseController;
import com.github.dragonhht.manager.model.Person;
import com.github.dragonhht.manager.params.Code;
import com.github.dragonhht.manager.service.PersonService;
import com.github.dragonhht.manager.util.ReturnDataUtils;
import com.github.dragonhht.manager.vo.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description.
 * User: huang
 * Date: 18-9-20
 */
@RestController
@RequestMapping("/person")
public class PersonController extends BaseController<Person, Integer> {

    @Autowired
    private PersonService personService;

    /**
     * 通过姓名查找老人.
     * @param name
     * @return
     */
    @GetMapping("/select/name")
    public ReturnData<List<Person>> findRecordByEmployee(@RequestParam("name") String name) {
        List<Person> personList = personService.getPersonByName(name);
        return ReturnDataUtils.returnDate(Code.SUCCESS, personList);
    }

    @GetMapping("/select/by/family/{id}")
    public ReturnData<List<Person>> findByFamily(@PathVariable("id") int id) {
        List<Person> personList = personService.getPersonByFamily(id);
        return ReturnDataUtils.returnDate(Code.SUCCESS, personList);
    }

}
