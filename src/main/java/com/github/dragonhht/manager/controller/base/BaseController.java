package com.github.dragonhht.manager.controller.base;

import com.github.dragonhht.manager.params.Code;
import com.github.dragonhht.manager.service.base.BaseService;
import com.github.dragonhht.manager.util.ReturnDataUtils;
import com.github.dragonhht.manager.vo.ReturnData;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresRoles;
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

    @ApiOperation(value = "获取数据", notes = "分页获取数据")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", dataType = "int",
                    required = true, value = "页码", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", name = "size", dataType = "int",
                    required = true, value = "每页数量", defaultValue = "0")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 801, message = "未登录"),
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 701, message = "失败"),
            @ApiResponse(code = 401, message = "未授权")
    })
    @GetMapping
    public Page<T> findAllPage(@RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                    @RequestParam(name = "size", defaultValue = "0", required = false) int size) throws Exception {
        return baseService.findAllByPage(page, size);
    }

    @ApiOperation(value = "通过Id获取数据", notes = "获取指定id的数据")
    @ApiResponses(value = {
            @ApiResponse(code = 801, message = "未登录"),
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 701, message = "失败"),
            @ApiResponse(code = 401, message = "未授权")
    })
    @GetMapping("/{id}")
    public ReturnData<Optional<T>> findById(@PathVariable("id") R id) throws Exception {
        Optional<T> family = baseService.findById(id);
        return ReturnDataUtils.returnDate(Code.SUCCESS, family);
    }
    //@RequiresRoles("EMPLOYEE")
    @PostMapping
    public ReturnData<T> save(@RequestBody T family) throws Exception {
        T data = baseService.save(family);
        return ReturnDataUtils.returnDate(Code.SUCCESS, data);
    }

    //@RequiresRoles("EMPLOYEE")
    @DeleteMapping("/{id}")
    public ReturnData<Boolean> delete(@PathVariable("id") R id) throws Exception {
        baseService.delete(id);
        return ReturnDataUtils.returnDate(Code.SUCCESS, true);
    }

/*    @GetMapping("/{id}/s/{attri}")
    public ReturnData getAllAttri(@RequestParam(name = "page", defaultValue = "0", required = false) int page,
                            @RequestParam(name = "size", defaultValue = "0", required = false) int size,
                            @PathVariable(name = "id") R id, @PathVariable(name="attri") String attri) throws Exception {
        Optional<T> data = baseService.findById(id);
        Method method = BeanUtil.getField(data.get(), attri);
        Object obj = BeanUtil.getField(data.get(), method, method.getReturnType());
        return ReturnDataUtils.returnDate(Code.SUCCESS, obj);
    }*/
}
