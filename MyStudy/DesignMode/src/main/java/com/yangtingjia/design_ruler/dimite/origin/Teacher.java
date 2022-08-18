package com.yangtingjia.design_ruler.dimite.origin;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨廷甲
 * 2022-07-03
 */
public class Teacher {
    private String name; //老师姓名

    private String clazz; //班级

    private static List<Student> studentList; //学生人数

    public Teacher() {
    }

    public Teacher(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
    }

    static {
        studentList = new ArrayList<>();
        studentList.add(new Student("花花",10,580));
        studentList.add(new Student("豆豆",54 , 356));
        studentList.add(new Student("秋雅",23 , 500));
        studentList.add(new Student("屁屁",5 , 600));
        studentList.add(new Student("吉吉",2 , 655));
    }

    public String getName() {
        return name;
    }

    public Teacher setName(String name) {
        this.name = name;
        return this;
    }

    public String getClazz() {
        return clazz;
    }

    public Teacher setClazz(String clazz) {
        this.clazz = clazz;
        return this;
    }

    public static List<Student> getStudentList() {
        return studentList;
    }

    public static void setStudentList(List<Student> studentList) {
        Teacher.studentList = studentList;
    }
}
