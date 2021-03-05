package com.hut.courseselection.interceptor;

import com.hut.courseselection.bean.Admin;
import com.hut.courseselection.bean.Student;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ChenJie on 2020/5/12 0012 .
 */
public class AdminLoginInterceptor implements HandlerInterceptor {
    /**
     * 拦截器，用于拦截管理员操作的相关页面，防止未登录就访问相关页面
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //判断用户是否登录
        Admin admin = (Admin) request.getSession().getAttribute("ADMIN_IN_SESSION");
        if(admin == null){
            request.setAttribute("msg","您还未登录，请先登录后访问！");
            request.getRequestDispatcher("/page/admin/login.jsp").forward(request,response);
            return false;
        }
        return true;
    }
}
