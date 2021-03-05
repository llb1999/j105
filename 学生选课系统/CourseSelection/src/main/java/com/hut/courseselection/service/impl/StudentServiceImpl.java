package com.hut.courseselection.service.impl;

import com.hut.courseselection.bean.Course;
import com.hut.courseselection.bean.Student;
import com.hut.courseselection.bean.Teacher;
import com.hut.courseselection.mapper.StudentMapper;
import com.hut.courseselection.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper mapper;

    public Student login(Student student) {
        return mapper.login(student);
    }

    public void register(Student student) {
        mapper.register(student);
    }
    public void addCourse(String studentName, String courseName, String courseTeacher) {
        mapper.addCourse(studentName,courseName,courseTeacher);
    }

    public Student displayStudentCheckedCourse(String studentName) {
        return mapper.displayStudentCheckedCourse(studentName);
    }

    public void deleteCourse(String studentName, String courseName,String teacherName) {
        mapper.deleteCourse(studentName,courseName,teacherName);
    }

    public List<Course> displayAllCourse() {
        return mapper.displayAllCourse();
    }

    @Override
    public List<Course> getCourseByStudentNameAndCourseName(String username, String courseName) {
        return mapper.getCourseByStudentNameAndCourseName(username,courseName);
    }

    @Override
    public Student getStudentInfoByStuId(Integer stu_id) {
        return mapper.getStudentInfoByStuId(stu_id);
    }

    @Override
    public void updateSelfInfo(Student student) {
        mapper.updateSelfInfo(student);
    }

}
