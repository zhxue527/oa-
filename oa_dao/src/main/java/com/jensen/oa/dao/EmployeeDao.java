package com.jensen.oa.dao;

import com.jensen.oa.entity.Department;
import com.jensen.oa.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @PackageName: com.jensen.oa.dao
 * @ClassName: DepartmentDao
 * @Description:
 * @Author: SKY
 * @Data:: 2020/04/06
 */
public interface EmployeeDao {
    void insert(Employee employee);
    void update(Employee employee);
    void delete(String sn);
    Employee select(String sn);
    List<Employee> selectAll();
    List<Employee> selectByDepartmentAndPost(@Param("dsn") String dsn, @Param("post") String post);
}
