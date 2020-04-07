package com.jensen.oa.dao;

import com.jensen.oa.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @PackageName: com.jensen.oa.dao
 * @ClassName: DepartmentDao
 * @Description:
 * @Author: SKY
 * @Data:: 2020/04/06
 */
//@Repository("departmentDao")
public interface DepartmentDao {
    void insert(Department department);
    void update(Department department);
    void delete(String sn);
    Department select(String sn);
    List<Department> selectAll();
}
