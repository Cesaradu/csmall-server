package com.gs.csmall.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryAddNewDTO implements Serializable {
    @ApiModelProperty(value = "类别名称", example = "家电", required = true)
    private String name;

    @ApiModelProperty(value = "父级类别id，如果是一级分类，则此属性值为0", example = "10", required = true)
    private Long parentId;

    @ApiModelProperty(value = "类别关键词", example = "家电,家用电器", required = true)
    private String keywords;

    @ApiModelProperty(value = "自定义排序序号", example = "1", required = true)
    private Integer sort;

    @ApiModelProperty(value = "图标的URL", example = "https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png", required = true)
    private String icon;

    @ApiModelProperty(value = "是否启用，1=启用，0=禁用", example = "1", required = true)
    private Integer enable;

    @ApiModelProperty(value = "是否显示在导航栏，1=显示，0=不显示", example = "1", required = true)
    private Integer display;
}
