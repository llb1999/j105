package com.hut.courseselection.test;

import com.hut.courseselection.bean.*;
import com.hut.courseselection.service.IStudentService;
import com.hut.courseselection.service.ITeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;


/**
 *
 * @author ChenJie
 * @date 2020/5/19 0019
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:mvc.xml")
public class App {




    /**
     * 这里全是开发阶段的测试方法，实际运行过程中不要运行这里的方法！！！
     */






    @Autowired
    private ApplicationContext context;
    /**
     * 学生操作区域
     */
    //测试学生登录
    @Test
    public void testStudentLogin(){
        Student student = new Student();
        student.setUsername("陈");
        student.setPassword("123456");

        IStudentService service = context.getBean(IStudentService.class);

        Student login = service.login(student);

        if (login == null){
            System.out.println("学生用户登录失败");
        }
        else{
            System.out.println("学生用户登录成功");
        }
    }
    //测试学生注册
    @Test
    public void testStudentSave(){
        Student student = new Student();
        student.setUsername("chen");
        student.setPassword("123456");

        IStudentService service = context.getBean(IStudentService.class);

        service.register(student);
    }
    //测试学生选课
    @Test
    public void testAddCourse(){
        IStudentService service = context.getBean(IStudentService.class);
//        service.addCourse(3,1);
    }
    //测试学生查已选课程
    @Test
    public void testDisplayCheckedCourse(){
        IStudentService service = context.getBean(IStudentService.class);
//        Student student = service.displayStudentCheckedCourse(2);
//        System.out.println(student);
//
//        for (Course course : student.getCourseList()){
//            System.out.println(course);
//        }
    }

    /**
     * 老师操作区域
     */
    //测试老师登录
    @Test
    public void testTeacherLogin(){
        Teacher teacher = new Teacher();
        teacher.setUsername("jack");
        teacher.setPassword("123456");
        ITeacherService service = context.getBean(ITeacherService.class);
        Teacher login = service.login(teacher);

        if (login == null){
            System.out.println("老师用户登录失败");
        }
        else{
            System.out.println("老师用户登录成功");
        }
    }
    //测试老师注册
    @Test
    public void testTeacherSave(){
        Teacher teacher = new Teacher();
        teacher.setUsername("july");
        teacher.setPassword("123456");

        ITeacherService service = context.getBean(ITeacherService.class);

        service.register(teacher);
    }
    //测试老师开课
    @Test
    public void testTeacherAddCourse(){
        ITeacherService service = context.getBean(ITeacherService.class);

        service.addCourse("jack","数据结构","3","23");
    }
    //测试老师管理开课班级
    @Test
    public void testManageCourse(){
        ITeacherService service = context.getBean(ITeacherService.class);

        Course course = service.manageCourse("贺俊文","熬夜梦游概论");

        System.out.println(course);
        for (TeacherPageDisplayInfo_Student   student :course.getStudentList()){
            System.out.println(student);
        }
    }

    @Test
    public  void test(){
        IStudentService service = context.getBean(IStudentService.class);
        Student student = service.displayStudentCheckedCourse("陈");
        for (StudentPageDisplayInfo_Course studentPageDisplayInfo_course : student.getCourseList()) {
            System.out.println(studentPageDisplayInfo_course);
        }
    }

}
