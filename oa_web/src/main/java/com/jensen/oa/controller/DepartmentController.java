package com.jensen.oa.controller;

import com.jensen.oa.entity.Department;
import com.jensen.oa.service.DepartmentService;
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
@Controller("departmentController")
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/list")
    public String list(Map<String, Object> map) {
        map.put("list", departmentService.getAll());
        return "department_list";
    }

    @RequestMapping("/to_add")
    public String toAdd(Map<String, Object> map) {
        map.put("department", new Department());
        return "department_add";
    }

    @RequestMapping(value = "/to_update", params = "sn")
    public String toUpdate(String sn, Map<String, Object> map) {
        map.put("department", departmentService.get(sn));
        return "department_update";
    }

    @RequestMapping(value = "/update", params = "sn")
    public String update(Department department) {
        departmentService.edit(department);
        return "redirect:list";
    }

    @RequestMapping("/add")
    public String add(Department department) {
        departmentService.add(department);
        return "redirect:list";
    }

    @RequestMapping(value = "/remove", params = "sn")
    public String remove(String sn) {
        departmentService.remove(sn);
        return "redirect:list";
    }
}
