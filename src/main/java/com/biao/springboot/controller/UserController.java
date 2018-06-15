package com.biao.springboot.controller;

import com.biao.springboot.dao.DepartmentDao;
import com.biao.springboot.dao.EmployeeDao;
import com.biao.springboot.entities.Department;
import com.biao.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Map;

@Controller
public class UserController {

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("passWord") String passWord,
                        HttpSession session,
                        Map<String,Object> errMsg){

        if(!StringUtils.isEmpty(userName) && "admin".equals(passWord)){
            //登录成功
            session.setAttribute("userLogin",userName);
            return "redirect:/main.html";
        }else{
            errMsg.put("msg","用户名密码错误！");
            return "login";
        }

    }
}
