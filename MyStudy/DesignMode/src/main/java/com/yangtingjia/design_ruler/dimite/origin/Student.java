package com.yangtingjia.design_ruler.dimite.origin;

/**
 * 杨廷甲
 * 2022-07-03
 */
public class Student {
    private String name; //学生姓名

    private int rank; //考试排名

    private double grade; // 总分

    public Student(String name, int rank, double grade) {
        this.name = name;
        this.rank = rank;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public int getRank() {
        return rank;
    }

    public Student setRank(int rank) {
        this.rank = rank;
        return this;
    }

    public double getGrade() {
        return grade;
    }

    public Student setGrade(double grade) {
        this.grade = grade;
        return this;
    }
}
