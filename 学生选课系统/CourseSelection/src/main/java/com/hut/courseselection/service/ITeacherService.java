package com.hut.courseselection.service;


import com.hut.courseselection.bean.AdminPageDisplayInfo_Teacher;
import com.hut.courseselection.bean.Course;
import com.hut.courseselection.bean.Teacher;

import java.util.List;

public interface ITeacherService {
    Teacher login(Teacher teacher);

    void register(Teacher teacher);

    void addCourse(String teacherName, String courseName, String course_score, String course_time);

    Course manageCourse(String teacherName, String courseName);

    List<Course> manageAllCourse(String username);

    void deleteCourse(String teacherName, String courseName);

    void updateStudentCourseScore(String courseName, String studentName, Integer score);

    void deleteStudentFromCourse(String studentName, String courseName);

    Teacher getTeacherInfoByStuId(Integer tea_id);

    void updateSelfInfo(Teacher teacher);

    List<Course> getCourseByTeacherNameAndCourseName(String username, String courseName);

    AdminPageDisplayInfo_Teacher displayTeacherOpenCourse(String teacherName);


}
