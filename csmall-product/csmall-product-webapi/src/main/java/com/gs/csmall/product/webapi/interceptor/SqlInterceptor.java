package com.gs.csmall.product.webapi.interceptor;


import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Properties;

// Statement prepare(Connection connection, Integer transactionTimeout) throws SQLException;
@Intercepts(@Signature(type = StatementHandler.class,
                       method = "prepare",
                       args = {Connection.class, Integer.class}))
public class SqlInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 获取sql语句
        Object target = invocation.getTarget();
        if (target instanceof StatementHandler) {
            StatementHandler statementHandler = (StatementHandler) target;
            BoundSql boundSql = statementHandler.getBoundSql();
            String sql = boundSql.getSql();

            sql = sql.toLowerCase().replaceAll("\\s+", " ").trim();
            System.out.println(sql);

            if (sql.startsWith("update ")) {
                int i = sql.indexOf(" set ");
                String s = "gmt_modified='" + LocalDateTime.now() + "',";
                String newSql = sql.substring(0, i+5) + s + sql.substring(i+5);
                System.out.println("当前执行的是更新数据库操作，自动补全更新时间");
                System.out.println(newSql);

                Field sqlField = boundSql.getClass().getDeclaredField("sql");
                sqlField.setAccessible(true);
                sqlField.set(boundSql, newSql);
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {
        Interceptor.super.setProperties(properties);
    }
}
