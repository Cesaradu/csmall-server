package com.gs.csmall.pojo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class CategoryAddNewVO implements Serializable {
    private Long id;
}
