package com.jensen.oa.controller;

import com.jensen.oa.entity.Employee;
import com.jensen.oa.service.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @PackageName: com.jensen.oa.controller
 * @ClassName: GlobalController
 * @Description:
 * @Author: SKY
 * @Data:: 2020/04/06
 */
@Controller("globalController")
public class GlobalController {

    @Autowired
    private GlobalService globalService;

    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpSession httpSession, @RequestParam String sn, @RequestParam String password) {
        Employee employee = globalService.login(sn, password);
        if (employee == null) {
            return "redirect:to_login";
        }
        httpSession.setAttribute("employee", employee);
        return "redirect:self";
    }

    @RequestMapping("/self")
    public String self(){
        return "self";
    }

    @RequestMapping("/quit")
    public String quit(HttpSession session) {
        session.setAttribute("employee", null);
        return "redirect:to_login";
    }

    @RequestMapping("/to_change_password")
    public String toChangePassword(){
        return "change_password";
    }

    @RequestMapping("/change_password")
    public String changePassword(HttpSession httpSession, @RequestParam String old, @RequestParam String new1, @RequestParam String new2) {
        Employee employee = (Employee) httpSession.getAttribute("employee");
        if (employee.getPassword().equals(old)
                && new1.equals(new2)) {
            employee.setPassword(new1);
            globalService.changePassword(employee);
            return "redirect:self";
        }
        return "redirect:to_change_password";
    }

}
