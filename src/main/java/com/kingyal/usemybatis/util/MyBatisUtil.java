package com.kingyal.usemybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    // 创建ThreadLocal绑定当前SqlSession对象
    private static final ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();
    static {
        try {
            // 加载配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            // 构建SqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession openSession() {
        SqlSession sqlSession = tl.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            tl.set(sqlSession);
        }
        return sqlSession;
    }

    public static void closeSession() {
        SqlSession sqlSession = tl.get();
        sqlSession.close();
    }

    public static void commit() {
        SqlSession sqlSession = openSession();
        sqlSession.commit();
        closeSession();
    }

    public static void rollback() {
        SqlSession sqlSession = openSession();
        sqlSession.rollback();
        closeSession();
    }

    public static <T> T getMapper(Class<T>  mapper) {
        SqlSession sqlSession = openSession();
        return sqlSession.getMapper(mapper);
    }

}
