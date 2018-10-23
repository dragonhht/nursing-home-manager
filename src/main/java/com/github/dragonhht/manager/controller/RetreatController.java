package com.github.dragonhht.manager.controller;

import com.github.dragonhht.manager.controller.base.BaseController;
import com.github.dragonhht.manager.model.ApplyForm;
import com.github.dragonhht.manager.model.RetreatApply;
import com.github.dragonhht.manager.params.Code;
import com.github.dragonhht.manager.params.FormStatus;
import com.github.dragonhht.manager.service.RetreatService;
import com.github.dragonhht.manager.util.ReturnDataUtils;
import com.github.dragonhht.manager.vo.ReturnData;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Description.
 * User: huang
 * Date: 18-10-5
 */
@RestController
@RequestMapping("/retreat")
public class RetreatController extends BaseController<RetreatApply, Integer> {

    @Autowired
    private RetreatService retreatService;

    /**
     * 根据状态查询申请表(可分页)
     * @param status
     * @param page
     * @param size
     * @return
     */
    @RequiresRoles("EMPLOYEE")
    @GetMapping("/select")
    public Page<RetreatApply> selectFormByStatus(@RequestParam("status") FormStatus status,
                                              @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                              @RequestParam(name = "size", defaultValue = "0", required = false) int size) {
        return  retreatService.findApplyFormsByStatus(page, size, status);
    }

    @RequiresRoles("EMPLOYEE")
    @PostMapping("/status/update/")
    public ReturnData<Boolean> updateStatus(@RequestParam("status") FormStatus status, @RequestParam("id") int id) {
        boolean ok = retreatService.updateStatus(status, id);
        return ReturnDataUtils.returnDate(Code.SUCCESS, ok);
    }

    @GetMapping("/select/by/person/{id}")
    public Page<RetreatApply> findRecordByPerson(@PathVariable("id") int id,
                                               @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                               @RequestParam(name = "size", defaultValue = "0", required = false) int sizie) {
        return retreatService.findRecordByPerson(id, page, sizie);
    }

}
