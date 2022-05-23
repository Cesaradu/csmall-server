package com.gs.csmall.product.webapi.mapper;

import com.gs.csmall.pojo.entity.Album;
import com.gs.csmall.pojo.vo.AlbumStandardVO;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumMapper {
    /**
     * 新增相册
     *
     * @param album 新增的相册对象
     * @return 受影响的行数
     */
    int insert(Album album);

    /**
     * 根据相册名称查询相册详情
     *
     * @param name 相册名称
     * @return 匹配的相册详情，如果没有匹配的数据，则返回null
     */
    AlbumStandardVO getByName(String name);
}
