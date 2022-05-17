package com.gs.smallproduct.webapi;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
@Slf4j
class SmallProductWebapiApplicationTests {
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
    }

    @Test
    void testGetConnection() throws Exception {
        log.debug("获取数据库的连接对象：{}", dataSource.getConnection());
    }

}
