package com.biao.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public @ResponseBody String sayHello(String name){

        return  "Hello: "+name;

    }

    /*@RequestMapping("/")
    public  String index(){
        return "login";
    }*/
}
