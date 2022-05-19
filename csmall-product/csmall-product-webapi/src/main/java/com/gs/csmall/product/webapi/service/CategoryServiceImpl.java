package com.gs.csmall.product.webapi.service;

import com.gs.csmall.commons.exception.ServiceException;
import com.gs.csmall.commons.response.ServiceCode;
import com.gs.csmall.pojo.dto.CategoryAddNewDTO;
import com.gs.csmall.pojo.entity.Category;
import com.gs.csmall.pojo.vo.CategoryStandardVO;
import com.gs.csmall.product.service.ICategoryService;
import com.gs.csmall.product.webapi.mapper.CategoryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.gs.csmall.commons.response.ServiceCode.*;

@Service
@Slf4j
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Long addNew(CategoryAddNewDTO categoryAddNewDTO) {
        // 日志
        log.debug("增加类别，参数：{}", categoryAddNewDTO);
        // 从参数中获取尝试增加的类别的名称
        String name = categoryAddNewDTO.getName();
        // 判断返回值是否不为null
        CategoryStandardVO checkNameQueryResult = categoryMapper.getByName(name);
        if (checkNameQueryResult != null) {
            // 是：存在与名称匹配的数据，则名称已经被占用，抛出异常（暂时抛出RuntimeException）
            log.warn("增加类别失败，尝试增加的类别名称【{}】已经存在！", name);
            throw new ServiceException(CONFLICT, "增加类别失败，尝试增加的类别名称已经存在！");
        }

        // 从参数中获取父类类别的id
        Long parentId = categoryAddNewDTO.getParentId();
        // 默认类别深度为1
        Integer depth = 1;
        // 声明父级类别
        CategoryStandardVO parentCategory = null;
        // 判断父级类别的id是否为0
        // -- 是：当前尝试增加的类别是一级分类，则深度为1
        if (parentId != 0) {
            // -- 基于父级类别id,调用mapper对象的getById()方法执行查询，查询父级类别
            parentCategory = categoryMapper.getById(parentId);
            // -- 判断查询结果是否为null
            if (parentCategory == null) {
                // -- -- 是：父级类别不存在，抛出异常（暂时抛出RuntimeException）
                log.warn("增加类别失败，选定的父级类别不存在！");
                throw new ServiceException(NOT_FOUND, "增加类别失败，选定的父级类别不存在！");
            } else {
                // -- -- 否：父级类别存在，从查询结果中获取父类级别的depth，将其增加1，得到当前尝试增加的类别的深度
                depth = parentCategory.getDepth() + 1;
            }
        }

        // 创建Category类型的对象
        Category category = new Category();
        // 补全Category对象的属性值：name / parentId / keywords / sort / icon / enable / display：来自参数categoryAddNewDTO
        BeanUtils.copyProperties(categoryAddNewDTO, category);
        // 补全Category对象的属性值：depth：以上处理的结果
        category.setDepth(depth);
        // 补全Category对象的属性值：parent：默认为0
        category.setParent(0);
        // 补全Category对象的属性值：gmtCreate / gmtModified：当前时间（LocalDateTime.now()）
        LocalDateTime now = LocalDateTime.now();
        category.setGmtCreate(now);
        category.setGmtModified(now);
        // 调用mapper对象的insert()方法执行插入数据，并获取返回值
        log.debug("增加类别，即将插入类别数据：{}", category);
        int rows = categoryMapper.insert(category);
        // 判断返回的受影响行数是否不为1
        if (rows != 1) {
            // 是：抛出异常（暂时抛出RuntimeException）
            log.warn("增加类别失败，插入类别数据时出现未知错误！");
            throw new ServiceException(INTERNAL_SERVER_ERROR, "增加类别失败，服务器忙，请稍后再次尝试！");
        }

        // 判断，父级类别不为0，且父级类别中的parent值为0
        if (parentId != 0 && parentCategory.getParent() == 0) {
            // >> 基于父级别的id，调用mapper的updateParentById()，将父级类别的“parent：是否为父级类别”更新为1，并获取返回值
            log.debug("增加类别，将父级类别的“是否为父级类别”设置为：是");
            rows = categoryMapper.updateParentById(parentId, 1);
            // >> 判断返回的受影响行数是否不为1
            if (rows != 1) {
                // 是：抛出异常（暂时抛出RuntimeException）
                log.warn("增加类别失败，更新父级类别数据时出现未知错误！");
                throw new ServiceException(INTERNAL_SERVER_ERROR, "增加类别失败，服务器忙，请稍后再次尝试！");
            }
        }

        // 返回新增的类别的id，即调用insert()时的参数中的id属性值
        log.debug("增加类别，完成，将返回新增的类别的id：{}", category.getId());
        return category.getId();
    }
}
