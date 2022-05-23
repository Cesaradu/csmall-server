package com.gs.csmall.product.webapi.service;

import com.gs.csmall.pojo.dto.CategoryAddNewDTO;
import com.gs.csmall.pojo.vo.CategoryListItemVO;
import com.gs.csmall.product.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Slf4j
public class CategoryServiceTests {
    @Autowired
    private ICategoryService categoryService;

    @Test
    @Sql(scripts = {"classpath:truncate.sql"})
    @Sql(scripts = {"classpath:truncate.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void testAddNew() {
        // 测试数据
        String name = "家用电器";
        Long parentId = 0L;
        String keywords = "家电,电视,冰箱,洗衣机";
        Integer sort = 88;
        String icon = "http://www.tedu.cn/logo.png";
        Integer enable = 1;
        Integer display = 1;
        CategoryAddNewDTO categoryAddNewDTO = new CategoryAddNewDTO();
        categoryAddNewDTO.setName(name);
        categoryAddNewDTO.setKeywords(keywords);
        categoryAddNewDTO.setSort(sort);
        categoryAddNewDTO.setIcon(icon);
        categoryAddNewDTO.setEnable(enable);
        categoryAddNewDTO.setDisplay(display);
        Long id = categoryService.addNew(categoryAddNewDTO);
        // 断言新增的数据的id为1
        Assertions.assertEquals(1, id);
    }

    @Test
    @Sql(scripts = {"classpath:truncate.sql", "classpath:insert_data.sql"})
    @Sql(scripts = {"classpath:truncate.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void testAddNewFailBecauseNameConflict() {
        // 测试数据
        String name = "家用电器";
        CategoryAddNewDTO categoryAddNewDTO = new CategoryAddNewDTO();
        categoryAddNewDTO.setName(name);
        // 执行测试，断言将抛出异常
        Assertions.assertThrows(RuntimeException.class, () -> {
            categoryService.addNew(categoryAddNewDTO);
        });
    }

    @Test
    @Sql(scripts = {"classpath:truncate.sql"})
    void testAddNewFailBecauseParentNotExist() {
        // 测试数据
        String name = "家用电器";
        Long parentId = 999999999L;
        CategoryAddNewDTO categoryAddNewDTO = new CategoryAddNewDTO();
        categoryAddNewDTO.setName(name);
        categoryAddNewDTO.setParentId(parentId);
        // 执行测试，断言将抛出异常
        Assertions.assertThrows(RuntimeException.class, () -> {
            categoryService.addNew(categoryAddNewDTO);
        });
    }

    @Test
    @Sql(scripts = {"classpath:truncate.sql", "classpath:insert_data.sql"})
    @Sql(scripts = {"classpath:truncate.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void testGetList() {
        List<CategoryListItemVO> list = categoryService.getList();
        log.debug("查询到的数据：{}", list);
    }
}
