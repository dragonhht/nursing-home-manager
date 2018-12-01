package com.github.dragonhht.manager.controller;

import com.github.dragonhht.manager.controller.base.BaseController;
import com.github.dragonhht.manager.model.NursRecord;
import com.github.dragonhht.manager.service.NursRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Description.
 * User: huang
 * Date: 2018-10-19
 */
@RestController
@RequestMapping("/nursRecord")
public class NursRecordController extends BaseController<NursRecord, Integer> {

    @Autowired
    private NursRecordService nursRecordService;

    /**
     * 根据护理项目编号获取护理记录.
     * @param id
     * @param page
     * @param sizie
     * @return
     */
    @GetMapping("/select/by/nures/{id}")
    public Page<NursRecord> findRecordByEmployee(@PathVariable("id") int id,
                                                    @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                                    @RequestParam(name = "size", defaultValue = "0", required = false) int sizie) {
        return nursRecordService.findRecordByProject(id, page, sizie);
    }

    /**
     * 根据老人编号获取护理记录
     * @param id
     * @param page
     * @param sizie
     * @return
     */
    @GetMapping("/select/by/person/{id}")
    public Page<NursRecord> findRecordByPerson(@PathVariable("id") int id,
                                                 @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                                 @RequestParam(name = "size", defaultValue = "0", required = false) int sizie) {
        return nursRecordService.findRecordByPerson(id, page, sizie);
    }

    /**
     * 根据记录上传者查询护理记录.
     * @param id
     * @param page
     * @param sizie
     * @return
     */
    @GetMapping("/select/by/create/{id}")
    public Page<NursRecord> findRecordByCreate(@PathVariable("id") int id,
                                               @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                               @RequestParam(name = "size", defaultValue = "0", required = false) int sizie) {
        return nursRecordService.findRecordByEmployee(id, page, sizie);
    }

}
