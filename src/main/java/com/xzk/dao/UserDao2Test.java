package com.xzk.dao;

import com.xzk.bean.User;
import com.xzk.util.SqlsessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserDao2Test {

    @Test
    void finda() {
        SqlSession session = SqlsessionUtil.getSession();
        UserDao2 mapper = session.getMapper(UserDao2.class);
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        int[] arr = new int[]{1,2,3,5};
        Map map =new HashMap<>();
        map.put("uids",list);
        List<User> findc = mapper.findc(map);
        for(User u: findc){
            System.out.println(u);
        }
    }

    @Test
    void findc() {
        SqlSession session = SqlsessionUtil.getSession();
        UserDao2 mapper = session.getMapper(UserDao2.class);
        Map map = new HashMap();
        map.put("begin",10001);
        map.put("end",10003);
        List<User> findd = mapper.finde(map);
        for(User u: findd){
            System.out.println(u);
        }
    }

    @Test
    void findb() {
    }
}