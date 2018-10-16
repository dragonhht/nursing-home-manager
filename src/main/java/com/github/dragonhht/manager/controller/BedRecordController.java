package com.github.dragonhht.manager.controller;

import com.github.dragonhht.manager.controller.base.BaseController;
import com.github.dragonhht.manager.model.BedRecord;
import com.github.dragonhht.manager.service.BedRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Description.
 * User: huang
 * Date: 18-9-20
 */
@RestController
@RequestMapping("/bedRecord")
public class BedRecordController extends BaseController<BedRecord, Integer> {

    @Autowired
    private BedRecordService bedRecordService;

    @GetMapping("/select/by/bed/{id}")
    public Page<BedRecord> findBedRecordByBed(@PathVariable("id") String id,
                                              @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                              @RequestParam(name = "size", defaultValue = "0", required = false) int size) {
        return bedRecordService.findBedRecordByBed(id, page, size);
    }

}
