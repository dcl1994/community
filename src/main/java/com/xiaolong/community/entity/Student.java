package com.xiaolong.community.entity;

/**
 * 学生测试类
 * @author dcl
 * @since 6:06 下午 2021/6/15
 */
public class Student {

    private String name;

    private Integer age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
