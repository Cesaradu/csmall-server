package com.gs.csmall.product.webapi.mapper;

import com.gs.csmall.pojo.entity.Category;
import org.springframework.stereotype.Repository;

@Repository // 如果无此注解，Idea可能提示无法装配的错误，但不影响运行
public interface CategoryMapper {
    /**
     * 插入类别数据
     * @param category 要插入的类别的数据
     * @return 受影响的行数
     */
    int insert(Category category);
}
