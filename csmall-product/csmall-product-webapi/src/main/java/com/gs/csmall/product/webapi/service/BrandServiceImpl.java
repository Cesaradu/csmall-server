package com.gs.csmall.product.webapi.service;

import com.gs.csmall.commons.exception.ServiceException;
import com.gs.csmall.commons.response.ServiceCode;
import com.gs.csmall.pojo.dto.BrandAddNewDto;
import com.gs.csmall.pojo.entity.Brand;
import com.gs.csmall.pojo.vo.BrandStandardVO;
import com.gs.csmall.product.service.IBrandService;
import com.gs.csmall.product.webapi.mapper.BrandMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BrandServiceImpl implements IBrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public Long addNew(BrandAddNewDto brandAddNewDto) {
        //检查品牌名是否存在
        String name = brandAddNewDto.getName();
        BrandStandardVO brandStandardVO = brandMapper.getByName(name);
        if (brandStandardVO != null) {
            throw new ServiceException(ServiceCode.CONFLICT, "新增品牌失败，品牌名称(" + name + ")已存在！");
        }

        //执行新增
        Brand brand = new Brand();
        BeanUtils.copyProperties(brandAddNewDto, brand);
        log.debug("新增品牌:" + brand);
        int rows = brandMapper.insert(brand);
        if (rows != 1) {
            throw new ServiceException(ServiceCode.INTERNAL_SERVER_ERROR, "新增品牌失败，服务器忙，请稍后再次尝试！");
        }
        //返回品牌ID
        return brand.getId();
    }
}
