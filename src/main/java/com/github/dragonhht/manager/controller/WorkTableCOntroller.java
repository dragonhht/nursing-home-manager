package com.github.dragonhht.manager.controller;

import com.github.dragonhht.manager.model.WorkTable;
import com.github.dragonhht.manager.params.Code;
import com.github.dragonhht.manager.service.WorkTableService;
import com.github.dragonhht.manager.util.ReturnDataUtils;
import com.github.dragonhht.manager.vo.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Description.
 * User: huang
 * Date: 2018-10-24
 */
@RestController
@RequestMapping("workTable")
public class WorkTableCOntroller {

    @Autowired
    private WorkTableService workTableService;

    @PostMapping("")
    public ReturnData<Integer> save(@RequestBody WorkTable workTable) {
        int id = workTableService.save(workTable);
        return ReturnDataUtils.returnDate(Code.SUCCESS, id);
    }

    @GetMapping()
    public String get() {
        return workTableService.getMsg();
    }

}
