package com.hut.courseselection.service;

import com.hut.courseselection.bean.Admin;
import com.hut.courseselection.bean.AdminPageDisplayInfo_Teacher;
import com.hut.courseselection.bean.Student;
import com.hut.courseselection.bean.Teacher;

import java.util.List;

/**
 * Created by ChenJie on 2020/5/28 0028 .
 */
public interface IAdminService {
    Admin login(Admin admin);

    List<Student> getAllStudentInfo();

    List<AdminPageDisplayInfo_Teacher> getAllTeacherInfo();

    void updateStudentPassword(String username, String password);

    void updateStudentCourseScore(String studentName, String courseName, int score);

    void deleteStudent(String studentName);

    void updateTeacherPassword(String username, String password);

    void deleteTeacher(String teacherName);
}
