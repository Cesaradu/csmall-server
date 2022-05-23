package com.gs.csmall.product.service;

import com.gs.csmall.pojo.dto.BrandAddNewDto;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IBrandService {
    /**
     * 增加品牌
     *
     * @param brandAddNewDto 新增的品牌对象
     */
    Long addNew(BrandAddNewDto brandAddNewDto);
}
