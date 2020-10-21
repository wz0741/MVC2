package com.xzk.dao;

import com.xzk.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    private ThreadLocal<String> threadLocal = new ThreadLocal<>();

    class A extends Thread{
        @Override
        public void run() {
            threadLocal.set("zs");
            System.out.println(threadLocal.get());
        }
    }

    class B extends Thread{
        @Override
        public void run() {
            System.out.println(threadLocal.get());
        }
    }
    @Test
    void getall() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(reader);
            SqlSession sqlSession = factory.openSession();

           /* List<User> objects = sqlSession.selectList("com.xzk.dao.UserDao.getall");
            for(User u: objects){
                System.out.println(u);
            }*/

           /* User user = sqlSession.selectOne("com.xzk.dao.UserDao.findById",1);
            System.out.println(user.toString());*/

          User user = new User();
            user.setName("zs1");
            user.setPassword("123456");
            user.setUsername("张三1");
            int insert = sqlSession.insert("com.xzk.dao.UserDao.add", user);
            System.out.println(user.getUid());
            System.out.println(insert);
            sqlSession.commit();

            /*Map map = sqlSession.selectOne("com.xzk.dao.UserDao.avg");
            System.out.println(map.get("min"));
            System.out.println(map.get("max"));
            System.out.println(map.get("avg"));
            sqlSession.close();
            reader.close();*/

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Test
    void test(){

        try {
            SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis.xml")).openSession();
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            List<User> users = mapper.getall();
            for(User u: users){
                System.out.println(u);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void thread(){
        UserDaoTest.A a = new A();
        UserDaoTest.B b = new B();
        a.start();
        b.start();
    }

}