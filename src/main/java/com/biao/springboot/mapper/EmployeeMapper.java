package com.biao.springboot.mapper;

import com.biao.springboot.bean.Employee;

public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
