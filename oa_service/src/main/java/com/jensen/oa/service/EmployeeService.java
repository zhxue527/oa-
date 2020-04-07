package com.jensen.oa.service;

import com.jensen.oa.entity.Department;
import com.jensen.oa.entity.Employee;

import java.util.List;

/**
 * @PackageName: com.jensen.oa.service
 * @ClassName: DepartmentService
 * @Description:
 * @Author: SKY
 * @Data:: 2020/04/06
 */
public interface EmployeeService {
    void add(Employee employee);
    void edit(Employee department);
    void remove(String sn);
    Employee get(String sn);
    List<Employee> getAll();
}
