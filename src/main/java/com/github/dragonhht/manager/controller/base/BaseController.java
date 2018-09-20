package com.github.dragonhht.manager.controller.base;

import com.github.dragonhht.manager.service.base.BaseService;
import com.github.dragonhht.manager.vo.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * 基本Controller.
 * User: huang
 * Date: 18-9-20
 */
@RestController
public abstract class BaseController<T, R> {
    @Autowired
    private BaseService<T, R> baseService;

    @GetMapping
    public Page<T> findAllPage(@RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                    @RequestParam(name = "size", defaultValue = "0", required = false) int size) throws Exception {
        return baseService.findAllByPage(page, size);
    }

    @GetMapping("/{id}")
    public ReturnData<Optional<T>> findById(@PathVariable("id") R id) throws Exception {
        Optional<T> family = baseService.findById(id);
        return new ReturnData<>(200, family);
    }

    @PostMapping
    public ReturnData<T> save(@RequestBody T family) throws Exception {
        T data = baseService.save(family);
        return new ReturnData<>(200, data);
    }

    @DeleteMapping
    public ReturnData<Boolean> delete(R id) throws Exception {
        baseService.delete(id);
        return new ReturnData<>(200, true);
    }
}
