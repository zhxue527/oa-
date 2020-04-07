package com.jensen.oa.service;

import com.jensen.oa.entity.Department;

import java.util.List;

/**
 * @PackageName: com.jensen.oa.service
 * @ClassName: DepartmentService
 * @Description:
 * @Author: SKY
 * @Data:: 2020/04/06
 */
public interface DepartmentService {
    void add(Department department);
    void edit(Department department);
    void remove(String sn);
    Department get(String sn);
    List<Department> getAll();
}
