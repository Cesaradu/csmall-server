package com.gs.csmall.product.webapi.mapper;

import com.gs.csmall.pojo.entity.Brand;
import com.gs.csmall.pojo.vo.BrandStandardVO;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandMapper {
    /**
     * 新增品牌
     *
     * @param brand 新增的品牌对象
     * @return 受影响的行数
     */
    int insert(Brand brand);

    /**
     * 根据品牌名称查询品牌详情
     *
     * @param name 品牌名称
     * @return 匹配的品牌详情，如果没有匹配的数据，则返回null
     */
    BrandStandardVO getByName(String name);
}
