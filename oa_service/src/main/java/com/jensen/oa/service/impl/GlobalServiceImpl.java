package com.jensen.oa.service.impl;

import com.jensen.oa.dao.EmployeeDao;
import com.jensen.oa.entity.Employee;
import com.jensen.oa.service.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @PackageName: com.jensen.oa.service.impl
 * @ClassName: GlobalServiceImpl
 * @Description:
 * @Author: SKY
 * @Data:: 2020/04/06
 */
@Service("globalService")
public class GlobalServiceImpl implements GlobalService {

    @Autowired
    private EmployeeDao employeeDao;

    public Employee login(String sn, String password) {
        Employee employee = employeeDao.select(sn);
        if (employee != null && employee.getPassword().equals(password)) {
            return employee;
        }
        return null;
    }

    public void changePassword(Employee employee) {
        employeeDao.update(employee);
    }
}
