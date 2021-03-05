package com.hut.courseselection.service.impl;

import com.hut.courseselection.bean.AdminPageDisplayInfo_Teacher;
import com.hut.courseselection.bean.Course;
import com.hut.courseselection.bean.Teacher;
import com.hut.courseselection.mapper.TeacherMapper;
import com.hut.courseselection.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    private TeacherMapper mapper;

    public Teacher login(Teacher teacher) {
        return mapper.login(teacher);
    }

    public void register(Teacher teacher) {
        mapper.register(teacher);
    }


    public void addCourse(String teacherName, String courseName,String courseScore,String courseTime) {
        mapper.addCourse(teacherName,courseName,courseScore,courseTime);
    }
    public void deleteCourse(String teacherName, String courseName) {
        mapper.deleteCourse(teacherName,courseName);
        mapper.deleteStudentSelectCourse(courseName);
    }

    public void updateStudentCourseScore(String courseName, String studentName, Integer score) {
        mapper.updateStudentCourseScore(courseName,studentName,score);
    }

    public void deleteStudentFromCourse(String studentName, String courseName) {
        mapper.deleteStudentFromCourse(studentName, courseName);
    }

    @Override
    public Teacher getTeacherInfoByStuId(Integer tea_id) {
        return mapper.getTeacherInfoByStuId(tea_id);
    }

    @Override
    public void updateSelfInfo(Teacher teacher) {
        mapper.updateSelfInfo(teacher);
    }

    @Override
    public List<Course> getCourseByTeacherNameAndCourseName(String username, String courseName) {
        return mapper.getCourseByTeacherNameAndCourseName(username, courseName);
    }

    @Override
    public AdminPageDisplayInfo_Teacher displayTeacherOpenCourse(String teacherName) {
        return mapper.displayTeacherCheckedCourse(teacherName);
    }

    public Course manageCourse(String teacherName, String courseName) {
        return mapper.manageCourse(teacherName,courseName);
    }

    public List<Course> manageAllCourse(String username) {
        return mapper.manageAllCourse(username);
    }



}
