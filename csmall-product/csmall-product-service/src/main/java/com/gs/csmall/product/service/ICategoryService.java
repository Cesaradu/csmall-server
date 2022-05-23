package com.gs.csmall.product.service;

import com.gs.csmall.pojo.dto.CategoryAddNewDTO;
import com.gs.csmall.pojo.vo.CategoryListItemVO;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Transactional
public interface ICategoryService {
    /**
     * 增加类别
     * @param categoryAddNewDTO 封装了增加类别时的参数的对象
     * @return 新增的类别的id
     */
    Long addNew(CategoryAddNewDTO categoryAddNewDTO);

    /**
     * 查询类别的列表
     *
     * @return 类别的列表，如果数据表中无数据，则返回长度为0的列表
     */
    List<CategoryListItemVO> getList();
}
