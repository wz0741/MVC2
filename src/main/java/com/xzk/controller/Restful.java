package com.xzk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class Restful {

    @RequestMapping(value = "/restful",method = RequestMethod.GET)
    public String get(HttpServletResponse response){


        System.out.println("get");
        return "getsuccess";
    }
    @RequestMapping(value = "/restful",method = RequestMethod.PUT)
    public String put(HttpServletResponse response){


        System.out.println("put");
        return "addsuccess";
    }
    @RequestMapping(value = "/restful",method = RequestMethod.DELETE)
    public String del(HttpServletResponse response){


        System.out.println("dlete");
        return "getsuccess";
    }
    @RequestMapping(value = "/restful",method = RequestMethod.POST)
    public String post(HttpServletResponse response){


        System.out.println("xinzeng");
        return "updatesuccess";
    }
}
