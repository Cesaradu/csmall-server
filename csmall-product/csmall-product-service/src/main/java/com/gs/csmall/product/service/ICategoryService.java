package com.gs.csmall.product.service;

import com.gs.csmall.pojo.dto.CategoryAddNewDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ICategoryService {
    /**
     * 增加类别
     * @param categoryAddNewDTO 封装了增加类别时的参数的对象
     * @return 新增的类别的id
     */
    Long addNew(CategoryAddNewDTO categoryAddNewDTO);
}
