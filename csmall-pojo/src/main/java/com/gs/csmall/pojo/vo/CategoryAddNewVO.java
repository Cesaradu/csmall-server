package com.gs.csmall.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class CategoryAddNewVO implements Serializable {
    @ApiModelProperty(value = "新增加的类别的id", position = 1)
    private Long id;
}
