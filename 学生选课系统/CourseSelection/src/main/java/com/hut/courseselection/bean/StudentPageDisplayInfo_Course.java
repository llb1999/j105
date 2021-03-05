package com.hut.courseselection.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ChenJie on 2020/5/25 0025 .
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 一个伪course类，跟course类相比，这里多了一个课程分数。
 * 单独用在学生页面中的展示课程的分数页面
 */
public class StudentPageDisplayInfo_Course extends AdminPageDisplayInfo_Teacher {
    private Integer id;
    private String courseName;
    private String teaName;
    private Integer score;
    private String courseScore;
    private String courseTime;

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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
