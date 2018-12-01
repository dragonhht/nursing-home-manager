package com.github.dragonhht.manager.controller.base;

import com.github.dragonhht.manager.params.Code;
import com.github.dragonhht.manager.service.base.BaseService;
import com.github.dragonhht.manager.util.ReturnDataUtils;
import com.github.dragonhht.manager.vo.ReturnData;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * 基本Controller.
 * User: huang
 * Date: 18-9-20
 */
@Api("基础增删改查")
@RestController
public abstract class BaseController<T, R> {
    @Autowired
    private BaseService<T, R> baseService;

    /**
     * 分页获取数据.
     */
    @GetMapping
    public Page<T> findAllPage(@RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                    @RequestParam(name = "size", defaultValue = "0", required = false) int size) throws Exception {
        return baseService.findAllByPage(page, size);
    }

    /**
     * 获取指定id的数据
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/{id}")
    public ReturnData<Optional<T>> findById(@PathVariable("id") R id) throws Exception {
        Optional<T> family = baseService.findById(id);
        return ReturnDataUtils.returnDate(Code.SUCCESS, family);
    }

    /**
     * 保存数据
     * @param family
     * @return
     * @throws Exception
     */
    @PostMapping
    public ReturnData<T> save(@RequestBody T family) throws Exception {
        T data = baseService.save(family);
        return ReturnDataUtils.returnDate(Code.SUCCESS, data);
    }

    /**
     * 删除数据
     * @param id
     * @return
     * @throws Exception
     */
    @DeleteMapping("/{id}")
    public ReturnData<Boolean> delete(@PathVariable("id") R id) throws Exception {
        baseService.delete(id);
        return ReturnDataUtils.returnDate(Code.SUCCESS, true);
    }
}
