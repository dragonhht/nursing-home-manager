package com.github.dragonhht.manager.controller;

import com.github.dragonhht.manager.controller.base.BaseController;
import com.github.dragonhht.manager.model.Person;
import com.github.dragonhht.manager.params.Code;
import com.github.dragonhht.manager.service.PersonService;
import com.github.dragonhht.manager.util.ReturnDataUtils;
import com.github.dragonhht.manager.vo.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
