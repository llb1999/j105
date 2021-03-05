package com.hut.courseselection.service.impl;

import com.hut.courseselection.bean.Admin;
import com.hut.courseselection.bean.AdminPageDisplayInfo_Teacher;
import com.hut.courseselection.bean.Student;
import com.hut.courseselection.bean.Teacher;
import com.hut.courseselection.mapper.AdminMapper;
import com.hut.courseselection.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ChenJie on 2020/5/28 0028 .
 */
@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminMapper mapper;

    public Admin login(Admin admin) {

        return mapper.login(admin);
    }

    public List<Student> getAllStudentInfo() {
        return mapper.getAllStudentInfo();
    }

    public List<AdminPageDisplayInfo_Teacher> getAllTeacherInfo() {
        return mapper.getAllTeacherInfo();
    }

    public void updateStudentPassword(String username, String password) {
        mapper.updateStudentPassword(username,password);
    }

    @Override
    public void updateStudentCourseScore(String studentName, String courseName, int score) {
        mapper.updateStudentCourseScore(studentName, courseName, score);
    }

    @Override
    public void deleteStudent(String studentName) {
        mapper.deleteStudent(studentName);
        mapper.deleteStudentCourse(studentName);
    }

    @Override
    public void updateTeacherPassword(String username, String password) {
        mapper.updateTeacherPassword(username,password);
    }

    @Override
    public void deleteTeacher(String teacherName) {
        mapper.deleteTeacher(teacherName);
        mapper.deleteTeacherCourse(teacherName);
    }
}
