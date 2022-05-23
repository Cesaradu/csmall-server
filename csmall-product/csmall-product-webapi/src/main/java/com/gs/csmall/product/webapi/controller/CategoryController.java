package com.gs.csmall.product.webapi.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.gs.csmall.commons.response.JsonResult;
import com.gs.csmall.pojo.dto.CategoryAddNewDTO;
import com.gs.csmall.pojo.vo.CategoryAddNewVO;
import com.gs.csmall.pojo.vo.CategoryListItemVO;
import com.gs.csmall.product.service.ICategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "1. 类别管理模块")
@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @ApiOperation("增加类别")
    @ApiOperationSupport(order = 2)
    @PostMapping("/add-new")
    public JsonResult<CategoryAddNewVO> addNew(@Valid CategoryAddNewDTO categoryAddNewDTO) {
        Long id = categoryService.addNew(categoryAddNewDTO);
        return JsonResult.ok(new CategoryAddNewVO().setId(id));
    }

    @ApiOperation("获取分类列表")
    @ApiOperationSupport(order = 1)
    @GetMapping("/getList")
    public JsonResult<List<CategoryListItemVO>> getList() {
        List<CategoryListItemVO> list = categoryService.getList();
        return JsonResult.ok(list);
    }
}
