package com.qianfeng.fxmall.commons.mybatis;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.IOException;
import java.io.InputStream;

/**
 * 对SqlSessionFactory进行封装，做到全局唯一
 */

@Configuration
public class SpringBean {

    private  static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws IOException {
        InputStream stream = Resources.getResourceAsStream("mybatis.cfg.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        return sqlSessionFactory;
    }

    @Scope("prototype")
    @Bean
    public SqlSession session(SqlSessionFactory sqlSessionFactory){
        SqlSession session = threadLocal.get();
        if (session == null){
            session = sqlSessionFactory.openSession();
            threadLocal.set(session);
        }
        return session;
    }
}
