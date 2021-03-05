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
public class TeacherPageDisplayInfo_Student {
    /**
     * 一个伪student类，跟student类相比，这里多了一个课程分数。
     * 单独用在教师页面中的展示学生成绩的页面
     */
    private Integer stu_id;
    private Integer id;
    private String username;
    private Integer score;

    public Integer getStu_id() {
        return stu_id;
    }

    public void setStu_id(Integer stu_id) {
        this.stu_id = stu_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
