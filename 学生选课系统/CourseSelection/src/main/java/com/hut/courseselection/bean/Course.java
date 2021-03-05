package com.hut.courseselection.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ChenJie on 2020/5/19 0019 .
 */
@Data@AllArgsConstructor@NoArgsConstructor
public class Course implements Serializable {
    private Integer id;
    private String courseName;
    private String teaName;
    private String courseScore;
    private String courseTime;

    private List<TeacherPageDisplayInfo_Student > studentList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getCourseScore() {
        return courseScore;
    }

    public void setCourseScore(String courseScore) {
        this.courseScore = courseScore;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public List<TeacherPageDisplayInfo_Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<TeacherPageDisplayInfo_Student> studentList) {
        this.studentList = studentList;
    }
}
