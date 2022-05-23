package com.gs.csmall.product.webapi.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.gs.csmall.commons.response.JsonResult;
import com.gs.csmall.pojo.dto.AlbumAddNewDTO;
import com.gs.csmall.pojo.vo.AlbumAddNewVO;
import com.gs.csmall.product.service.IAlbumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "3. 想管理模块")
@RestController
@RequestMapping("/albums")
public class AlbumController {
    @Autowired
    private IAlbumService albumService;

    @PostMapping("/add-album")
    @ApiOperation(value = "新增相册", notes = "需要商品后台【写】权限：/pms/product/update")
    @ApiOperationSupport(order = 10)
    public JsonResult<AlbumAddNewVO> addAlbum(@Valid AlbumAddNewDTO albumAddNewDTO) {
        Long id = albumService.addAlbum(albumAddNewDTO);
        return JsonResult.ok(new AlbumAddNewVO().setId(id));
    }
}
