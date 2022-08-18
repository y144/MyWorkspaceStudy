package com.yangtingjia.design_ruler.dimite.origin;

import java.util.HashMap;
import java.util.Map;

/**
 * 杨廷甲
 * 2022-07-03
 */
public class Principal {
    private Teacher teacher = new Teacher("梨花","三年级一班");

    //查询班级信息、总分、学生人数、平均分
    public Map<String,Object> queryClassInfo(){
        //获取班级信息：学生人数、总分、平均分

        //学生人数
        int stuCount = clazzStudentCount();
        //班级总成绩
        double totalScore = clazzTotalScore();
        //班级平均成绩
        double averageScore = clazzAgerageScore();

        //组装对象，实际开发过程中会有对应的类
        Map<String,Object> mapObj = new HashMap<>();
        mapObj.put("班级", teacher.getClazz());
        mapObj.put("老师姓名", teacher.getName());
        mapObj.put("学生人数", stuCount);
        mapObj.put("总分", totalScore);
        mapObj.put("平均分", averageScore);
        return mapObj;
    }

    private double clazzAgerageScore() {
        double totalScore = 0;
        for (Student stu : Teacher.getStudentList()) {
            totalScore += stu.getGrade();
        }
        return totalScore / Teacher.getStudentList().size();

    }

    private double clazzTotalScore() {

        double totalScore = 0;
        for (Student stu : Teacher.getStudentList()) {
            totalScore += stu.getGrade();
        }
        return totalScore;
    }

    private int clazzStudentCount() {

        return Teacher.getStudentList().size();
    }

    /**
     * 以上实现方法虽然简单可用，但是违背了迪米特法则，因为校长需要了解到每个学生的情况，
     * 如果所有班级都让校长统计的话，代码就会显得非常的臃肿，不利于维护和扩展
     */
}
