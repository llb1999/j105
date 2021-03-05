package com.hut.courseselection.controller;

import com.hut.courseselection.bean.Course;
import com.hut.courseselection.bean.StudentPageDisplayInfo_Course;
import com.hut.courseselection.bean.Student;
import com.hut.courseselection.service.IStudentService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by ChenJie on 2020/5/21 0021 .
 */
@Setter
@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private IStudentService service;

    /**
     * 学生登录检查页面
     * @param student
     * @param model
     * @param session
     * @return 登录成功就跳转到显示已选课程页面，登录失败则返回登录页面
     */
    @RequestMapping("/studentLogin")
    public String studentLogin(Student student, Model model, HttpSession session){
        //判断前台传入的学生身份是否合法
        Student loginStudent = service.login(student);
        if(loginStudent != null){
            //合法
            session.setAttribute("STUDENT_IN_SESSION",loginStudent);
            return "/student/displayCheckedCourse.do";
        }else{
            model.addAttribute("msg","账号或密码错误，请重试！");
            return "/page/student/login.jsp";
        }
    }

    /**
     * 学生显示个人全部已选课程页面
     * @param model
     * @param session
     * @return 将查到的数据，封装成list容器，返回到前台页面
     */
    @RequestMapping("/displayCheckedCourse")
    public String displayCheckedCourse(Model model,HttpSession session){
        Student sessionStudent = (Student) session.getAttribute("STUDENT_IN_SESSION");
        List<StudentPageDisplayInfo_Course> courses = service.displayStudentCheckedCourse(sessionStudent.getUsername()).getCourseList();
        model.addAttribute("checkedCourses",courses);
        return "/page/student/displayCourse.jsp";
    }

    /**
     * 学生显示全部老师所开课程，用于选课
     * @param model
     * @return 将数据封装到list容器，返回前台页面
     */
    @RequestMapping("/displayAllCourse")
    public String displayAllCourse(Model model){
        List<Course> courses = service.displayAllCourse();
        model.addAttribute("allCourses",courses);
        return "/page/student/selectCourse.jsp";
    }

    /**
     * 学生删除已选课程操作
     * @param courseName
     * @param session
     * @return 删除课程成功之后，以重定向的方式，重新发送展示全部课程的请求，在前台页面展示
     */
    @RequestMapping("/deleteCourse")
    public String deleteCourse(String courseName,String teacherName,HttpSession session){
        Student sessionStudent = (Student) session.getAttribute("STUDENT_IN_SESSION");
        service.deleteCourse(sessionStudent.getUsername(),courseName,teacherName);
        return "redirect:/student/displayCheckedCourse.do";
    }

    /**
     * 学生新增选课操作
     * @param courseName
     * @param session
     * @return 选课成功之后，以重定向的方式，重新发送展示全部课程的请求，在前台页面展示
     */
    @RequestMapping("/addCourse")
    public String addCourse(String courseName,String courseTeacher, HttpSession session, HttpServletResponse response) throws IOException {
        Student sessionStudent = (Student) session.getAttribute("STUDENT_IN_SESSION");

        List<Course> course = service.getCourseByStudentNameAndCourseName(sessionStudent.getUsername(),courseName);
        //判断是否已经选过该课程
        if(course.isEmpty()){
            //未选
            service.addCourse(sessionStudent.getUsername(),courseName,courseTeacher);
            return "redirect:/student/displayCheckedCourse.do";
        }else {
            //已选
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('您已经选过该课程了');</script>");
            response.getWriter().flush();
            return "/student/displayAllCourse.do";
        }
    }

    /**
     * 在学生修改个人信息之前先通过这个函数把信息查询出来，写到相应位置，便于修改
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/displaySelfInfo")
    public String displaySelfInfo(HttpSession session,Model model){
        Student sessionStudent = (Student) session.getAttribute("STUDENT_IN_SESSION");

        Student student = service.getStudentInfoByStuId(sessionStudent.getStu_id());

        model.addAttribute("student",student);
        return "/page/student/updateSelfInfo.jsp";
    }

    /**
     * 学生把修改后的数据进行保存，并提示修改成功
     * @param student
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/updateSelfInfo")
    public String updateSelfInfo(Student student,HttpServletResponse response) throws IOException {
        service.updateSelfInfo(student);

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<script>alert('修改个人信息成功');</script>");
        response.getWriter().flush();
        return "/student/displaySelfInfo.do";
    }
}
