package com.jensen.oa.service;

import com.jensen.oa.entity.Employee;

/**
 * @PackageName: com.jensen.oa.service
 * @ClassName: GlobalService
 * @Description:
 * @Author: SKY
 * @Data:: 2020/04/06
 */
public interface GlobalService {
    Employee login(String sn, String password);
    void changePassword(Employee employee);
}
