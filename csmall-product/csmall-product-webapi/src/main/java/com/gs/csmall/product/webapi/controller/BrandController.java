package com.gs.csmall.product.webapi.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.gs.csmall.commons.response.JsonResult;
import com.gs.csmall.pojo.dto.BrandAddNewDto;
import com.gs.csmall.pojo.vo.BrandAddNewVO;
import com.gs.csmall.product.service.IBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/brands")
@Api(tags = "2. 品牌管理模块")
public class BrandController {
    @Autowired
    private IBrandService brandService;

    @ApiOperation(value = "增加品牌", notes = "需要商品后台【写】权限：/pms/product/update")
    @ApiOperationSupport(order = 10)
    @PostMapping("/add-brand")
    public JsonResult<BrandAddNewVO> addNew(@Valid BrandAddNewDto brandAddNewDto) {
        Long id = brandService.addNew(brandAddNewDto);
        return JsonResult.ok(new BrandAddNewVO().setId(id));
    }
}
