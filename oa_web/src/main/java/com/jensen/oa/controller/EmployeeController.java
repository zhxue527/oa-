package com.jensen.oa.controller;

import com.jensen.oa.entity.Department;
import com.jensen.oa.entity.Employee;
import com.jensen.oa.global.Content;
import com.jensen.oa.service.DepartmentService;
import com.jensen.oa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @PackageName: com.jensen.oa.controller
 * @ClassName: DepartmentController
 * @Description:
 * @Author: SKY
 * @Data:: 2020/04/06
 */
@Controller("employeeController")
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/list")
    public String list(Map<String, Object> map) {
        map.put("list", employeeService.getAll());
        return "employee_list";
    }

    @RequestMapping("/to_add")
    public String toAdd(Map<String, Object> map) {
        map.put("dlist", departmentService.getAll());
        map.put("plist", Content.getPosts());
        map.put("employee", new Employee());
        return "employee_add";
    }

    @RequestMapping(value = "/to_update", params = "sn")
    public String toUpdate(String sn, Map<String, Object> map) {
        map.put("employee", employeeService.get(sn));
        map.put("dlist", departmentService.getAll());
        map.put("plist", Content.getPosts());
        return "employee_update";
    }

    @RequestMapping(value = "/update", params = "sn")
    public String update(Employee employee) {
        employeeService.edit(employee);
        return "redirect:list";
    }

    @RequestMapping("/add")
    public String add(Employee employee) {
        employeeService.add(employee);
        return "redirect:list";
    }

    @RequestMapping(value = "/remove", params = "sn")
    public String remove(String sn) {
        employeeService.remove(sn);
        return "redirect:list";
    }
}
