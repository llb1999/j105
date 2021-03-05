package com.hut.courseselection.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by ChenJie on 2020/5/19 0019 .
 */
@Data@NoArgsConstructor@AllArgsConstructor
public class Student {
    private Integer id;
    private Integer stu_id;
    private String username;
    private String password;
    private String age;
    private String classNum;
    private String college;
    private String phoneNumber;

    private List<StudentPageDisplayInfo_Course> courseList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStu_id() {
        return stu_id;
    }

    public void setStu_id(Integer stu_id) {
        this.stu_id = stu_id;
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

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<StudentPageDisplayInfo_Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<StudentPageDisplayInfo_Course> courseList) {
        this.courseList = courseList;
    }
}
