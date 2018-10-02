package com.github.dragonhht.manager.controller;

import com.github.dragonhht.manager.controller.base.BaseController;
import com.github.dragonhht.manager.model.ApplyForm;
import com.github.dragonhht.manager.model.Person;
import com.github.dragonhht.manager.params.Code;
import com.github.dragonhht.manager.params.FormStatus;
import com.github.dragonhht.manager.service.ApplyFormService;
import com.github.dragonhht.manager.util.ReturnDataUtils;
import com.github.dragonhht.manager.vo.ReturnData;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Description.
 * User: huang
 * Date: 18-9-20
 */
@RestController
@RequestMapping("/applyFrom")
public class ApplyFormController extends BaseController<ApplyForm, Integer> {

    @Autowired
    private ApplyFormService applyFormService;

    /**
     * 从申请表中保存老人数据.
     * @param id 申请表id
     * @return
     * @throws Exception
     */
    @RequiresRoles("EMPLOYEE")
    @PostMapping("/save/person")
    public ReturnData<Person> savePersonByForm(int id) throws Exception {
        Person person = applyFormService.savePersonByApply(id);
        return ReturnDataUtils.returnDate(Code.SUCCESS, person);
    }

    /**
     * 根据状态查询申请表(可分页)
     * @param status
     * @param page
     * @param size
     * @return
     */
    //@RequiresRoles("EMPLOYEE")
    @GetMapping("/select")
    public Page<ApplyForm> selectFormByStatus(@RequestParam("status") FormStatus status,
                  @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                  @RequestParam(name = "size", defaultValue = "0", required = false) int size) {
        return  applyFormService.findApplyFormsByStatus(page, size, status);
    }


}
