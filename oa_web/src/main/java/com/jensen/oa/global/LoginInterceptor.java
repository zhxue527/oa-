package com.jensen.oa.global;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @PackageName: com.jensen.oa.global
 * @ClassName: LoginInterceptor
 * @Description:
 * @Author: SKY
 * @Data:: 2020/04/06
 */
public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();
        if (url.toLowerCase().indexOf("login") >= 0) {
            return true;
        }

        HttpSession session = request.getSession();
        if (session.getAttribute("employee") != null) {
            return true;
        }

        response.sendRedirect("/to_login");
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
