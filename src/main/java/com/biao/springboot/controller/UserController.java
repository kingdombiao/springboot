package com.biao.springboot.controller;

import com.biao.springboot.dao.EmployeeDao;
import com.biao.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/emps")
    public String getAllEmps(Map<String,Object> map){
        Collection<Employee> employees = employeeDao.getAll();
        map.put("emps",employees);
        return "list";
    }



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
