package com.xzk.dao;

import com.xzk.bean.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    public List<User> getall();

    public User findById(int uid);

    public int add(User user);

    public Map avg();
}
