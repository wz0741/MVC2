package com.xzk.dao;

import com.xzk.bean.User;

import java.util.List;
import java.util.Map;

public interface UserDao2 {

    public List<User> finda(List list);
    public List<User> findc(Map map);
    public List<User> findb(int[] arr);

    public List<User> findd(Map map);
    public List<User> finde(Map map);
}
