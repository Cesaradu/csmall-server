package com.gs.csmall.product.webapi.mapper;

import com.gs.csmall.pojo.entity.Category;
import com.gs.csmall.pojo.vo.CategoryListItemVO;
import com.gs.csmall.pojo.vo.CategoryStandardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Slf4j
public class CategoryMapperTests {
    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    @Sql(scripts = {"classpath:truncate.sql"})
    @Sql(scripts = {"classpath:truncate.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void testInsert() {
        String name = "电子数码";
        Category cate = new Category();
        cate.setName(name);
        int rows = categoryMapper.insert(cate);
        // 断言结果：受影响的行数是1
        Assertions.assertEquals(1, rows);
        Assertions.assertEquals(1, cate.getId());
    }

    @Test
    @Sql(scripts = {"classpath:truncate.sql", "classpath:insert_data.sql"})
    @Sql(scripts = {"classpath:truncate.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void testGetById() {
        Long id = 1L;
        CategoryStandardVO cate = categoryMapper.getById(id);
        // 断言结果：查询结果不为null
        Assertions.assertNotNull(cate);
    }

    @Test
    @Sql(scripts = {"classpath:truncate.sql", "classpath:insert_data.sql"})
    @Sql(scripts = {"classpath:truncate.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void testGetByName() {
        // 测试数据
        String name = "家用电器";
        // 执行测试
        CategoryStandardVO category = categoryMapper.getByName(name);
        // 断言结果：查询结果不为null
        Assertions.assertNotNull(category);
    }

    @Test
    @Sql(scripts = {"classpath:truncate.sql"})
    void testGetByNameFailBecauseNotExist() {
        // 测试数据
        String name = "NOT_EXIST";
        // 执行测试
        CategoryStandardVO category = categoryMapper.getByName(name);
        // 断言结果：查询结果为null（因为没有匹配的数据）
        Assertions.assertNull(category);
    }

    @Test
    @Sql(scripts = {"classpath:truncate.sql", "classpath:insert_data.sql"})
    @Sql(scripts = {"classpath:truncate.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void testUpdateById() {
        Long id = 1L;
        Integer parent = 1;
        int rows = categoryMapper.updateParentById(id, parent);
        // 断言结果：受影响的行数是1
        Assertions.assertEquals(1, rows);
    }

    @Test
    @Sql(scripts = {"classpath:truncate.sql"})
    void testUpdateParentByIdFailBecauseNotExist() {
        // 测试数据
        Long id = 999999999L;
        Integer parent = 1;
        // 执行测试
        int rows = categoryMapper.updateParentById(id, parent);
        // 断言结果：受影响的行数是0（因为没有数据被更新）
        Assertions.assertEquals(0, rows);
    }

    @Test
    @Sql(scripts = {"classpath:truncate.sql"})
    void testGetByIdFailBecauseNotExist() {
        // 测试数据
        Long id = 999999999L;
        // 执行测试
        CategoryStandardVO category = categoryMapper.getById(id);
        // 断言结果：查询结果为null（因为没有匹配的数据）
        Assertions.assertNull(category);
    }

    @Test
    @Sql(scripts = {"classpath:truncate.sql", "classpath:insert_data.sql"})
    @Sql(scripts = {"classpath:truncate.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void testGetList() {
        List<CategoryListItemVO> list = categoryMapper.getList();
        log.debug("查询到的数据：{}", list);
    }
}
