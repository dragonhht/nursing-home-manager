package com.github.dragonhht.manager.controller;

import com.github.dragonhht.manager.controller.base.BaseController;
import com.github.dragonhht.manager.model.OutingRecord;
import com.github.dragonhht.manager.service.OutRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Description.
 * User: huang
 * Date: 2018-10-19
 */
@RestController
@RequestMapping("/outRecord")
public class OutRecordController extends BaseController<OutingRecord, Integer> {

    @Autowired
    private OutRecordService outRecordService;

    @GetMapping("/select/by/person/{id}")
    public Page<OutingRecord> findRecordByPerson(@PathVariable("id") int id,
                                                 @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                                 @RequestParam(name = "size", defaultValue = "0", required = false) int sizie) {
        return outRecordService.findRecordByPerson(id, page, sizie);
    }

    @GetMapping("/select/by/create/{id}")
    public Page<OutingRecord> findRecordByCreate(@PathVariable("id") int id,
                                                 @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                                 @RequestParam(name = "size", defaultValue = "0", required = false) int sizie) {
        return outRecordService.findRecordByEmployee(id, page, sizie);
    }

}
