package com.github.dragonhht.manager.controller;

import com.github.dragonhht.manager.controller.base.BaseController;
import com.github.dragonhht.manager.model.Family;
import com.github.dragonhht.manager.service.FamilyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description.
 * User: huang
 * Date: 18-9-20
 */
@Api("家属Controller")
@RestController
@RequestMapping("/family")
public class FamilyController extends BaseController<Family, Integer> {

    @Autowired
    private FamilyService familyService;

}
