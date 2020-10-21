package com.xzk.dao;

import com.xzk.bean.User;
import com.xzk.bean.Work;
import com.xzk.util.SqlsessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordDaoTest {

    @Test
    void findbyId() {
        SqlSession session = SqlsessionUtil.getSession();
        WordDao mapper = session.getMapper(WordDao.class);
        Work work = mapper.findbyId(1);
        System.out.println(work.getWork());
        List<User> users = work.getUsers();
        for(User u:users){
            System.out.println(u);
        }

    }
}