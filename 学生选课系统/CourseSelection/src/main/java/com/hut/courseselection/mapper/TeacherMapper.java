package com.hut.courseselection.mapper;

import com.hut.courseselection.bean.AdminPageDisplayInfo_Teacher;
import com.hut.courseselection.bean.Course;
import com.hut.courseselection.bean.Student;
import com.hut.courseselection.bean.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    void register(Teacher teacher);

    void addCourse(@Param("teacherName") String teacherName, @Param("courseName") String courseName, @Param("courseScore") String courseScore, @Param("courseTime") String courseTime);

    Teacher login(Teacher teacher);

    Course manageCourse(@Param("teacherName") String teacherName, @Param("courseName") String courseName);

    List<Course> manageAllCourse(@Param("teacherName") String teacherName);

    void deleteCourse(@Param("teacherName") String teacherName, @Param("courseName") String courseName);

    void deleteStudentSelectCourse(@Param("courseName") String courseName);

    void updateStudentCourseScore(@Param("courseName") String courseName, @Param("studentName") String studentName, @Param("score") Integer score);

    void deleteStudentFromCourse(@Param("studentName") String studentName, @Param("courseName") String courseName);

    Teacher getTeacherInfoByStuId(@Param("tea_id") Integer tea_id);

    void updateSelfInfo(Teacher teacher);

    List<Course> getCourseByTeacherNameAndCourseName(@Param("username") String username, @Param("courseName") String courseName);

    AdminPageDisplayInfo_Teacher displayTeacherCheckedCourse(@Param("teacherName") String teacherName);
}
