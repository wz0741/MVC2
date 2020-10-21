package com.xzk.dao;

import com.xzk.bean.User;
import com.xzk.bean.Work;

import java.util.List;

public interface WordDao {

    //根据id查找对应职业的用户
    public Work  findbyId(int id);
    //查询学生信息以及对应的年级信息
    public List<User> findAll();
}
