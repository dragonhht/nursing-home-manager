package com.github.dragonhht.manager.controller;

import com.github.dragonhht.manager.controller.base.BaseController;
import com.github.dragonhht.manager.model.Bed;
import com.github.dragonhht.manager.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description.
 * User: huang
 * Date: 18-9-20
 */
@RestController
@RequestMapping("/bed")
public class BedController extends BaseController<Bed, String> {

    @Autowired
    private BedService bedService;

    /**
     * 根据是否使用，获取床位信息.
     * @param isUse
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @GetMapping("/select")
    public Page<Bed> selectBedByStatus(@RequestParam("isUse") boolean isUse,
                                       @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                       @RequestParam(name = "size", defaultValue = "0", required = false) int size) throws Exception {
        return bedService.getBedsByStatus(page, size, isUse);
    }

}
