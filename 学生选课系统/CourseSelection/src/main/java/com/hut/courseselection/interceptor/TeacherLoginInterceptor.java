package com.hut.courseselection.interceptor;

import com.hut.courseselection.bean.Student;
import com.hut.courseselection.bean.Teacher;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ChenJie on 2020/5/12 0012 .
 */
public class TeacherLoginInterceptor implements HandlerInterceptor {
    /**
     * 拦截器，用于拦截教师操作的相关页面，防止未登录就访问相关页面
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //判断用户是否登录
        Teacher teacher = (Teacher) request.getSession().getAttribute("TEACHER_IN_SESSION");
        if(teacher == null){
            request.setAttribute("msg","您还未登录，请先登录后访问！");
            request.getRequestDispatcher("/page/teacher/login.jsp").forward(request,response);
            return false;
        }
        return true;
    }
}
