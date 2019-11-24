package com.biao.springboot.controller;

import com.biao.springboot.dao.DepartmentDao;
import com.biao.springboot.dao.EmployeeDao;
import com.biao.springboot.entities.Department;
import com.biao.springboot.entities.Employee;
import com.biao.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("/getEmpById/{id}")
    @ResponseBody
    public com.biao.springboot.bean.Employee getEmpById(@PathVariable("id") Integer id){
        com.biao.springboot.bean.Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }


    //添加员工页面
    @GetMapping("/emp")
    public String toAddEmpPage(Map<String, Object> map) {
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("depts", departments);
        return "emp/add";
    }

    //添加员工
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //修改员工页面
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Map<String, Object> map) {
        Employee employee = employeeDao.get(id);
        map.put("emp", employee);

        //显示所有部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("depts", departments);
        return "emp/add";
    }

    //修改员工
    @PutMapping("/emp")
    public String editEmp(Employee employee) {
        System.out.println("修改的员工数据：" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }


    //删除员工
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    //查询员工
    @GetMapping("/emps")
    public String getAllEmps(Map<String, Object> map) {
        Collection<Employee> employees = employeeDao.getAll();
        map.put("emps", employees);
        return "emp/list";
    }
}
