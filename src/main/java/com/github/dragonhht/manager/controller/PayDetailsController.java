package com.github.dragonhht.manager.controller;

import com.github.dragonhht.manager.model.PayDetails;
import com.github.dragonhht.manager.service.PayDetailsService;
import com.github.dragonhht.manager.service.base.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Description.
 * User: huang
 * Date: 2018-10-19
 */
@RestController
@RequestMapping("/payDetail")
public class PayDetailsController extends BaseServiceImp<PayDetails, Integer> {

    @Autowired
    private PayDetailsService payDetailsService;

    @GetMapping("/select/by/person/{id}")
    public Page<PayDetails> findRecordByPerson(@PathVariable("id") int id,
                                               @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                               @RequestParam(name = "size", defaultValue = "0", required = false) int sizie) {
        return payDetailsService.findRecordByPerson(id, page, sizie);
    }

    @GetMapping("/select/by/create/{id}")
    public Page<PayDetails> findRecordByCreate(@PathVariable("id") int id,
                                               @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                               @RequestParam(name = "size", defaultValue = "0", required = false) int sizie) {
        return payDetailsService.findRecordByEmployee(id, page, sizie);
    }

}
