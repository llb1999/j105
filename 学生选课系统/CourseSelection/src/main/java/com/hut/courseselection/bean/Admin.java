package com.hut.courseselection.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ChenJie on 2020/5/28 0028 .
 */
@Data@NoArgsConstructor@AllArgsConstructor
public class Admin {
    private Integer id;
    private String username;
    private String password;
}
