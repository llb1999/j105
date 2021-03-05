package com.hut.courseselection.controller;

import com.hut.courseselection.bean.Course;
import com.hut.courseselection.bean.Student;
import com.hut.courseselection.bean.Teacher;
import com.hut.courseselection.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by ChenJie on 2020/5/21 0021 .
 */
@Controller
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    private ITeacherService service;

    /**
     * 老师登录检查页面
     * @param teacher
     * @param model
     * @param session
     * @return 登录成功则返回到管理课程页面，失败则携带错误信息返回登录页面
     */
    @RequestMapping("/teacherLogin")
    public String teacherLogin(Teacher teacher, Model model, HttpSession session){
        //判断前台传入的教师身份是否合法
        Teacher loginTeacher = service.login(teacher);
        if(loginTeacher != null){
            //合法
            session.setAttribute("TEACHER_IN_SESSION",loginTeacher);
            return "/teacher/displayManageAllCourse.do";
        }else{
            model.addAttribute("msg","账号或密码错误，请重试！");
            return "/page/teacher/login.jsp";
        }
    }

    /**
     * 老师显示管理他所开的课程的页面
     * @param model
     * @param session
     * @return 将数据查出来到list容器，返回给前台页面
     */
    @RequestMapping("/displayManageAllCourse")
    public String displayManageAllCourse(Model model,HttpSession session){
        Teacher sessionTeacher = (Teacher) session.getAttribute("TEACHER_IN_SESSION");
        List<Course> courses = service.manageAllCourse(sessionTeacher.getUsername());
        model.addAttribute("allCourse",courses);
        return "/page/teacher/manageCourse.jsp";
    }

    /**
     * 显示单个课程信息
     * @param model
     * @param session
     * @param courseName
     * @return 将数据查出来到一个对象，返回给前台页面
     */
    @RequestMapping("/displaySingleCourse")
    public String displaySingleCourse(Model model,HttpSession session,String courseName){
        Teacher sessionTeacher = (Teacher) session.getAttribute("TEACHER_IN_SESSION");
        Course course = service.manageCourse(sessionTeacher.getUsername(),courseName);
        model.addAttribute("course",course);
        return "/page/teacher/manageSingleCourse.jsp";
    }

    /**
     * 老师开课页面
     * @param course
     * @param session
     * @return 开课成功后，重定向到管理所开的课程页面
     */
    @RequestMapping("/addCourse")
    public String addCourse(Course course,HttpSession session,HttpServletResponse response) throws IOException {
        Teacher sessionTeacher = (Teacher) session.getAttribute("TEACHER_IN_SESSION");

        List<Course> courses = service.getCourseByTeacherNameAndCourseName(sessionTeacher.getUsername(),course.getCourseName());
        //判断该教师是否已经开过该课程
        if(courses.isEmpty()){
            //没有重复
            service.addCourse(sessionTeacher.getUsername(),course.getCourseName(),course.getCourseScore(),course.getCourseTime());
            return "redirect:/teacher/displayManageAllCourse.do";
        }else {
            //重复
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('课程名重复，不能重复开设');</script>");
            response.getWriter().flush();
            return "/page/teacher/addCourse.jsp";
        }


    }

    /**
     * 老师删除自己所开的课程
     * @param courseName
     * @param session
     * @return 开课成功后，重定向到管理所开的课程页面
     */
    @RequestMapping("/deleteCourse")
    public String deleteCourse(String courseName,HttpSession session){
        Teacher sessionTeacher = (Teacher) session.getAttribute("TEACHER_IN_SESSION");
        service.deleteCourse(sessionTeacher.getUsername(),courseName);
        return "redirect:/teacher/displayManageAllCourse.do";
    }

    /**
     * 老师更新学生成绩
     * @param courseName
     * @param studentName
     * @param score
     * @return 更新之后，重新加载页面
     */
    @RequestMapping("/updateStudentCourseScore")
    public String updateStudentCourseScore(String courseName,String studentName,Integer score,Model model,HttpSession session){
        service.updateStudentCourseScore(courseName,studentName,score);
        Teacher sessionTeacher = (Teacher) session.getAttribute("TEACHER_IN_SESSION");
        Course course = service.manageCourse(sessionTeacher.getUsername(),courseName);
        model.addAttribute("course",course);

        return "/page/teacher/manageSingleCourse.jsp";
    }

    /**
     * 老师把不需要的学生从自己的所开的课程里面剔除
     * @param studentName
     * @param courseName
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/deleteStudentFromCourse")
    public String deleteStudentFromCourse(String studentName,String courseName,Model model,HttpSession session){
        service.deleteStudentFromCourse(studentName,courseName);
        Teacher sessionTeacher = (Teacher) session.getAttribute("TEACHER_IN_SESSION");
        Course course = service.manageCourse(sessionTeacher.getUsername(),courseName);
        model.addAttribute("course",course);

        return "/page/teacher/manageSingleCourse.jsp";
    }

    /**
     * 在老师修改个人信息之前先通过这个函数把信息查询出来，写到相应位置，便于修改
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/displaySelfInfo")
    public String displaySelfInfo(HttpSession session,Model model){
        Teacher sessionTeacher = (Teacher) session.getAttribute("TEACHER_IN_SESSION");

        Teacher teacher = service.getTeacherInfoByStuId(sessionTeacher.getTea_id());

        model.addAttribute("teacher",teacher);
        return "/page/teacher/updateSelfInfo.jsp";
    }

    /**
     * 老师把修改后的数据进行保存，并提示修改成功
     * @param teacher
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/updateSelfInfo")
    public String updateSelfInfo(Teacher teacher, HttpServletResponse response) throws IOException {
        service.updateSelfInfo(teacher);

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<script>alert('修改个人信息成功');</script>");
        response.getWriter().flush();
        return "/teacher/displaySelfInfo.do";
    }
}
