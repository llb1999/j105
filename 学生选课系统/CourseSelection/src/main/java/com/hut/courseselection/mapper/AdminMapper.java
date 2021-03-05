package com.hut.courseselection.mapper;

import com.hut.courseselection.bean.Admin;
import com.hut.courseselection.bean.AdminPageDisplayInfo_Teacher;
import com.hut.courseselection.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by ChenJie on 2020/5/28 0028 .
 */
public interface AdminMapper {
    Admin login(Admin admin);

    List<Student> getAllStudentInfo();

    List<AdminPageDisplayInfo_Teacher> getAllTeacherInfo();

    void updateStudentPassword(@Param("username") String username, @Param("password") String password);

    void updateStudentCourseScore(@Param("studentName") String studentName, @Param("courseName") String courseName, @Param("score") int score);

    void deleteStudent(@Param("studentName") String studentName);

    void deleteStudentCourse(@Param("studentName") String studentName);

    void updateTeacherPassword(@Param("username") String username, @Param("password") String password);

    void deleteTeacher(@Param("teacherName") String teacherName);

    void deleteTeacherCourse(@Param("teacherName") String teacherName);
}
