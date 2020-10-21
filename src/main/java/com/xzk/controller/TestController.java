package com.xzk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TestController {
    @RequestMapping(value = "/test")
    public String test(String username,Integer age, HttpSession session){
        String value="value";
        session.setAttribute("username",value);
        System.out.println(5/0);
        System.out.println("username"+username);
        System.out.println(age);
        return "success";
    }

    @RequestMapping("/out")
    public String out(HttpSession session){
        session.invalidate();
        return "login";
    }

    @ExceptionHandler(Exception.class)
    public String ex(){
        return "error";
    }
}
