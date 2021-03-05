package com.hut.courseselection.mapper;


import com.hut.courseselection.bean.Course;
import com.hut.courseselection.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    void register(Student student);

    void addCourse(@Param("studentName") String studentName, @Param("courseName") String courseName, @Param("courseTeacher") String courseTeacher);

    Student login(Student student);

    Student displayStudentCheckedCourse(@Param("studentName") String studentName);

    void deleteCourse(@Param("studentName") String studentName, @Param("courseName") String courseName, @Param("teacherName") String teacherName);

    List<Course> displayAllCourse();

    List<Course> getCourseByStudentNameAndCourseName(@Param("username") String username, @Param("courseName") String courseName);

    Student getStudentInfoByStuId(@Param("stu_id") Integer stu_id);

    void updateSelfInfo(Student student);
}
