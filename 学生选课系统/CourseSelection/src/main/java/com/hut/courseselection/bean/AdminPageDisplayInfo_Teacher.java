package com.hut.courseselection.bean;

/**
 * Created by ChenJie on 2020/5/28 0028 .
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 一个伪Teacher类，跟Teacher类相比，这里多了一个课程列表。
 * 单独用在学生页面中的展示课程的分数页面
 */
@Data@AllArgsConstructor@NoArgsConstructor
public class AdminPageDisplayInfo_Teacher {

    private Integer id;
    private Integer tea_id;
    private String username;
    private String password;
    private String age;
    private String college;
    private String professionalTitle;
    private String phoneNumber;

    private List<Course> courseList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTea_id() {
        return tea_id;
    }

    public void setTea_id(Integer tea_id) {
        this.tea_id = tea_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getProfessionalTitle() {
        return professionalTitle;
    }

    public void setProfessionalTitle(String professionalTitle) {
        this.professionalTitle = professionalTitle;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
