package com.jensen.oa.service.impl;

import com.jensen.oa.dao.DepartmentDao;
import com.jensen.oa.entity.Department;
import com.jensen.oa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PackageName: com.jensen.oa.service.impl
 * @ClassName: DepartmentServiceImpl
 * @Description:
 * @Author: SKY
 * @Data:: 2020/04/06
 */

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public void add(Department department) {
        departmentDao.insert(department);
    }

    public void edit(Department department) {
        departmentDao.update(department);
    }

    public void remove(String sn) {
        departmentDao.delete(sn);
    }

    public Department get(String sn) {
        return departmentDao.select(sn);
    }

    public List<Department> getAll() {
        return departmentDao.selectAll();
    }
}
