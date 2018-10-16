package com.github.dragonhht.manager.controller;

import com.github.dragonhht.manager.model.Role;
import com.github.dragonhht.manager.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 初始化.
 * User: huang
 * Date: 18-10-16
 */
@RestController
public class InitController {

    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping("/init")
    public boolean init() {
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));
        roleRepository.save(new Role("EMPLOYEE"));
        return true;
    }

}
