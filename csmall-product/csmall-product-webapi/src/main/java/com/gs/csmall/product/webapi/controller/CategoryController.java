package com.gs.csmall.product.webapi.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.gs.csmall.commons.response.JsonResult;
import com.gs.csmall.pojo.dto.CategoryAddNewDTO;
import com.gs.csmall.pojo.vo.CategoryAddNewVO;
import com.gs.csmall.product.service.ICategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "1. 类别管理模块")
@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @ApiOperation("增加类别")
    @ApiOperationSupport(order = 10)
    @PostMapping("/add-new")
    public JsonResult<CategoryAddNewVO> addNew(@Valid CategoryAddNewDTO categoryAddNewDTO) {
        Long id = categoryService.addNew(categoryAddNewDTO);
        return JsonResult.ok(new CategoryAddNewVO().setId(id));
    }
}
