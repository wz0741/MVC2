package com.xzk.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class SqlsessionUtil {
    private static ThreadLocal<SqlSession> sqlSession = new ThreadLocal<>();
    private static SqlSessionFactory sqlSessionFactory;

    static {
        //读取配置文件,获取SqlsessionFactory对象
        Reader mybatis = null;
        try {
            mybatis = Resources.getResourceAsReader("mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory= new SqlSessionFactoryBuilder().build(mybatis);
    }

    public static SqlSession getSession(){
        //获取session,假如ThreadLocal中没有Session对象,
        // 说明是第一次调用该方法,从SqlsessionFactory`获取Session对象然后存入ThreadLoca
        SqlSession session = sqlSession.get();
        if(session==null){
            session=sqlSessionFactory.openSession();
            sqlSession.set(session);
        }
        return session;
    }

    public static  void closeSession(){
        //关闭session
        SqlSession session=sqlSession.get();
        if(session!=null){
            session.close();
            sqlSession.remove();
        }
    }

}
