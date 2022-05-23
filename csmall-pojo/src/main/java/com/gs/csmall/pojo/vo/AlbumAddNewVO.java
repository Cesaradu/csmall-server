package com.gs.csmall.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class AlbumAddNewVO implements Serializable {
    /**
     * 相册id
     */
    @ApiModelProperty(value = "相册ID", position = 1)
    private Long id;
}
