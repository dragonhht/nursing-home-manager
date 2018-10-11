package com.github.dragonhht.manager.controller;

import com.github.dragonhht.manager.controller.base.BaseController;
import com.github.dragonhht.manager.model.BedRecord;
import com.github.dragonhht.manager.service.BedRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
