package com.biao.springboot.mapper;

import com.biao.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById( Integer id);

    @Options(useGeneratedKeys = true ,keyProperty = "id")
    @Insert("insert into department (department_name) values (#{departmentName})")
    public Integer insertDept(Department department);

    @Delete("delete from department where id = #{id}")
    public Integer deleteDeptById(Integer id);

    @Update("update department set department_name = #{departmentName} where id = #{id}")
    public Integer updaterDept(Department department);
}
