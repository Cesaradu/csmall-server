package com.gs.csmall.product.service;

import com.gs.csmall.pojo.dto.AlbumAddNewDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IAlbumService {
    /**
     * 新增相册
     * @param albumAddNewDTO
     * @return
     */
    Long addAlbum(AlbumAddNewDTO albumAddNewDTO);
}
