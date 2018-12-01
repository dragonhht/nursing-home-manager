package com.github.dragonhht.manager.controller;

import com.github.dragonhht.manager.controller.base.BaseController;
import com.github.dragonhht.manager.model.LogRecord;
import com.github.dragonhht.manager.service.LogRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Description.
 * User: huang
 * Date: 18-10-13
 */
@RestController
@RequestMapping("/logRecord")
public class LogRecordController extends BaseController<LogRecord, Integer> {

    @Autowired
    private LogRecordService logRecordService;

    /**
     * 根据员工编号查询日志.
     * @param id
     * @param page
     * @param sizie
     * @return
     */
    @GetMapping("/select/by/employee/{id}")
    public Page<LogRecord> findLogRecordByEmployee(@PathVariable("id") int id,
                                                   @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                                   @RequestParam(name = "size", defaultValue = "0", required = false) int sizie) {
        return logRecordService.findLogRecordByEmployee(id, page, sizie);
    }

    /**
     * 根据老人编号查询日志记录.
     * @param id
     * @param page
     * @param sizie
     * @return
     */
    @GetMapping("/select/by/person/{id}")
    public Page<LogRecord> findLogRecordByPerson(@PathVariable("id") int id,
                                                 @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                                 @RequestParam(name = "size", defaultValue = "0", required = false) int sizie) {
        return logRecordService.findLogRecordByPerson(id, page, sizie);
    }

}
