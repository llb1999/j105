package com.hut.courseselection.service;

import com.hut.courseselection.bean.Course;
import com.hut.courseselection.bean.Student;

import java.util.List;

public interface IStudentService {
    Student login(Student student);

    void register(Student student);

    void addCourse(String studentName, String courseName, String courseTeacher);

    Student displayStudentCheckedCourse(String studentName);

    void deleteCourse(String studentName, String courseName, String teacherName);

    List<Course> displayAllCourse();

    List<Course> getCourseByStudentNameAndCourseName(String username, String courseName);

    Student getStudentInfoByStuId(Integer stu_id);

    void updateSelfInfo(Student student);
}

