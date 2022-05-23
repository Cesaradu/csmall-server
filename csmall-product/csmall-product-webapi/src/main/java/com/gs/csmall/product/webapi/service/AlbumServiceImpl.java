package com.gs.csmall.product.webapi.service;

import com.gs.csmall.commons.exception.ServiceException;
import com.gs.csmall.commons.response.ServiceCode;
import com.gs.csmall.pojo.dto.AlbumAddNewDTO;
import com.gs.csmall.pojo.entity.Album;
import com.gs.csmall.pojo.vo.AlbumStandardVO;
import com.gs.csmall.product.service.IAlbumService;
import com.gs.csmall.product.webapi.mapper.AlbumMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AlbumServiceImpl implements IAlbumService {
    @Autowired
    private AlbumMapper albumMapper;

    @Override
    public Long addAlbum(AlbumAddNewDTO albumAddNewDTO) {
        log.debug("增加相册：{}", albumAddNewDTO);
        // 检查名称是否被占用
        String name = albumAddNewDTO.getName();
        AlbumStandardVO albumStandardVO = albumMapper.getByName(name);
        if (albumStandardVO != null) {
            throw new ServiceException(ServiceCode.CONFLICT, "新增相册失败，相册名称(" + name + ")已存在！");
        }

        // 执行插入相册数据
        Album album = new Album();
        album.setName(name);
        album.setDescription(albumAddNewDTO.getDescription());
        log.info("新增相册数据：{}", album);
        int rows = albumMapper.insert(album);
        if (rows != 1) {
            throw new ServiceException(ServiceCode.INTERNAL_SERVER_ERROR, "新增相册失败，服务器忙，请稍后再次尝试！");
        }
        return album.getId();
    }
}
