package com.xzk.controller;

import com.xzk.bean.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Administrator
 * springmvc
 * 面向对象面向君  不负代码不负卿
 */
@Controller
public class JsonController {

    /*@RequestMapping("/testuser")
    public @ResponseBody  User getuser(){
        User users = new User();
        users.setName("张安");
        users.setAge(19);
        System.out.println("getuser---------->");
        return  users;
    }

    @RequestMapping("/getusers")
    public @ResponseBody List<User> getusers(){
        List list=new ArrayList();
        for (int i = 0; i < 5; i++) {
            User users = new User();
            users.setName("张安"+i);
            users.setAge(19+i);
            list.add(users);
        }
        System.out.println("getusers2------>");
        return  list;
    }*/
}
