package com.reactiveJavaProject.sec04Operators.helper;

import com.reactiveJavaProject.courseUtil.Util;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {

    private int userId;
    private String name;

    public User(int userId) {
        this.userId = userId;
        this.name = Util.faker().name().fullName();
    }

}