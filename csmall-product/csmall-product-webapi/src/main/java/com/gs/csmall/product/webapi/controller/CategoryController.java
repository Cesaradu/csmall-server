package com.gs.csmall.product.webapi.controller;

import com.gs.csmall.commons.response.JsonResult;
import com.gs.csmall.pojo.dto.CategoryAddNewDTO;
import com.gs.csmall.pojo.vo.CategoryAddNewVO;
import com.gs.csmall.product.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping("/add-new")
    public JsonResult<CategoryAddNewVO> addNew(CategoryAddNewDTO categoryAddNewDTO) {
        Long id = categoryService.addNew(categoryAddNewDTO);
        return JsonResult.ok(new CategoryAddNewVO().setId(id));
    }
}
