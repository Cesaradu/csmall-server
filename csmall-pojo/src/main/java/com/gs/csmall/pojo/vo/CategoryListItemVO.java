package com.gs.csmall.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryListItemVO implements Serializable {
    @ApiModelProperty(value = "数据id", position = 1)
    private Long id;

    @ApiModelProperty(value = "类别名称", position = 2)
    private String name;

    @ApiModelProperty(value = "父级类别id，如果是一级分类，则此属性值为0", position = 3)
    private Long parentId;

    @ApiModelProperty(value = "深度，最顶级类别的深度为1，次级为2，以此类推", position = 4)
    private Integer depth;

    @ApiModelProperty(value = "图标的URL", position = 5)
    private String icon;

    @ApiModelProperty(value = "是否启用，1=启用，0=禁用", position = 6)
    private Integer enable;

    @ApiModelProperty(value = "是否显示在导航栏，1=显示，0=不显示", position = 7)
    private Integer display;
}
