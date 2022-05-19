package com.gs.csmall.product.webapi.mapper;

import com.gs.csmall.pojo.entity.Category;
import com.gs.csmall.pojo.vo.CategoryStandardVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository // 如果无此注解，Idea可能提示无法装配的错误，但不影响运行
public interface CategoryMapper {
    /**
     * 插入类别数据
     * @param category 要插入的类别的数据
     * @return 受影响的行数
     */
    int insert(Category category);

    /**
     * 根据类别名称获取类别详情
     *
     * @param name 类别名称
     * @return 匹配的类别详情，如果没有匹配的数据，则返回null
     */
    CategoryStandardVO getByName(String name);

    /**
     * 根据类别id获取类别详情
     *
     * @param id 类别id
     * @return 匹配的类别详情，如果没有匹配的数据，则返回null
     */
    CategoryStandardVO getById(Long id);

    /**
     * 根据类别id更新类别”是否为父级类别“
     *
     * @param id     类别id
     * @param parent 是否为父级类别，1=是，-0否
     * @return 受影响的行数
     */
    int updateParentById(@Param("id") Long id, @Param("parent") Integer parent);
}
