package com.hut.courseselection.controller;

import com.hut.courseselection.bean.*;
import com.hut.courseselection.service.IAdminService;
import com.hut.courseselection.service.IStudentService;
import com.hut.courseselection.service.ITeacherService;
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
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;
    @Autowired
    private IStudentService studentService;
    @Autowired
    private ITeacherService teacherService;

    /**
     * 管理员登录检查页面
     * @param admin
     * @param model
     * @param session
     * @return 登录成功就跳转到相应页面，登录失败则返回登录页面
     */
    @RequestMapping("/adminLogin")
    public String adminLogin(Admin admin, Model model, HttpSession session){
        //判断前台传入的管理员身份是否合法
        Admin loginAdmin = adminService.login(admin);
        if(loginAdmin != null){
            //合法
            session.setAttribute("ADMIN_IN_SESSION",loginAdmin);
            return "/page/admin/index.jsp";
        }else{
            model.addAttribute("msg","账号或密码错误，请重试！");
            return "/page/admin/login.jsp";
        }
    }


    @RequestMapping("/displayAllStudentInfo")
    public String displayAllStudentInfo(Model model){
        List<Student> allStudentInfoList = adminService.getAllStudentInfo();
        for (Student student : allStudentInfoList) {
            System.out.println(student);
        }
        model.addAttribute("allStudentInfoList",allStudentInfoList);
        return "/page/admin/displayAllStudentInfo.jsp";
    }

    @RequestMapping("/displaySingleStudentCheckedCourseInfo")
    public String displaySingleStudentCheckedCourseInfo(String studentName,Model model){
        Student student = studentService.displayStudentCheckedCourse(studentName);

        model.addAttribute("courseList",student.getCourseList());
        return "/page/admin/displaySingleStudentCheckedCourseInfo.jsp";
    }

    @RequestMapping("/displaySingleStudentSelfInfo")
    public String displaySingleStudentSelfInfo(String studentName,Model model){
        //从前台传的全部数据中公，选中当前学生的信息，传到下一个页面
        //这里是学生的信息和选课信息全被查出来，但是实际上只需要个人信息
        Student student = studentService.displayStudentCheckedCourse(studentName);
        model.addAttribute("student",student);
        return "/page/admin/displaySingleStudentSelfInfo.jsp";
    }

    @RequestMapping("/updateStudentSelfInfo")
    public String updateStudentSelfInfo(Student student, HttpServletResponse response) throws IOException {
        studentService.updateSelfInfo(student);

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<script>alert('修改个人信息成功');</script>");
        response.getWriter().flush();

        return "/admin/displayAllStudentInfo.do";
    }


    @RequestMapping("/displayAllTeacherInfo")
    public String displayAllTeacherInfo(Model model){
        List<AdminPageDisplayInfo_Teacher> allTeacherInfoList = adminService.getAllTeacherInfo();
        model.addAttribute("allTeacherInfoList",allTeacherInfoList);
        return "/page/admin/displayAllTeacherInfo.jsp";
    }




    @RequestMapping("/displaySingleTeacherCheckedCourseInfo")
    public String displaySingleTeacherCheckedCourseInfo(String teacherName,Model model){
        AdminPageDisplayInfo_Teacher teacher = teacherService.displayTeacherOpenCourse(teacherName);
        System.out.println(teacher);
        model.addAttribute("courseList",teacher.getCourseList());
        return "/page/admin/displaySingleTeacherOpenCourseInfo.jsp";
    }

    @RequestMapping("/displaySingleTeacherSelfInfo")
    public String displaySingleTeacherSelfInfo(String teacherName,Model model){
        //从前台传的全部数据中公，选中当前学生的信息，传到下一个页面
        //这里是学生的信息和选课信息全被查出来，但是实际上只需要个人信息
        AdminPageDisplayInfo_Teacher teacher = teacherService.displayTeacherOpenCourse(teacherName);
        model.addAttribute("teacher",teacher);
        System.out.println(teacher);
        return "/page/admin/displaySingleTeacherSelfInfo.jsp";
    }

    @RequestMapping("/updateTeacherSelfInfo")
    public String updateTeacherSelfInfo(Teacher teacher, HttpServletResponse response) throws IOException {
        teacherService.updateSelfInfo(teacher);
        System.out.println(teacher);

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<script>alert('修改个人信息成功');</script>");
        response.getWriter().flush();

        return "/admin/displayAllTeacherInfo.do";
    }






    @RequestMapping("updateStudentPassword")
    public String updateStudentPassword(String username,String password){
        adminService.updateStudentPassword(username,password);

        return "/admin/displayAllStudentInfo.do";
    }


    @RequestMapping("updateStudentCourseScore")
    public String updateStudentCourseScore(String studentName,String courseName,String score) {
        if (score.equals("挂科")) {
            adminService.updateStudentCourseScore(studentName, courseName, 0);
        } else {
            adminService.updateStudentCourseScore(studentName, courseName, Integer.parseInt(score));
        }

        return "/page/admin/displaySingleStudentCheckedCourseInfo.jsp";
    }



    @RequestMapping("deleteStudent")
    public String deleteStudent(String studentName){

        adminService.deleteStudent(studentName);
        return "/admin/displayAllStudentInfo.do";
    }

    @RequestMapping("deleteTeacher")
    public String deleteTeacher(String teacherName){

        adminService.deleteTeacher(teacherName);
        return "/admin/displayAllTeacherInfo.do";
    }

    @RequestMapping("updateTeacherPassword")
    public String updateTeacherPassword(String username,String password){
        adminService.updateTeacherPassword(username,password);

        return "/admin/displayAllTeacherInfo.do";
    }

}
