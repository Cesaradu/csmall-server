package com.gs.csmall.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class BrandAddNewVO implements Serializable {
    @ApiModelProperty(value = "", position = 1)
    private Long id;
}
