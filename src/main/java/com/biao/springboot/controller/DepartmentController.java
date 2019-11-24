package com.biao.springboot.controller;

import com.biao.springboot.bean.Department;
import com.biao.springboot.mapper.DepartmentMapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DepartmentMapper departmentMapper;

    @GetMapping("/query")
    public List<Map<String, Object>> queryDept() {
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList("select * from department");
        return mapList;
    }

    @GetMapping("/getDeptById/{id}")
    public Department getDeptById(@PathVariable("id") Integer id) {

        Department dept = departmentMapper.getDeptById(id);
        return dept;
    }


    @GetMapping("/insetDept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }
}
