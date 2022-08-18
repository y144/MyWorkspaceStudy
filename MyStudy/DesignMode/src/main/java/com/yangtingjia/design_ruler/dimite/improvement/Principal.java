package com.yangtingjia.design_ruler.dimite.improvement;


import com.yangtingjia.design_ruler.dimite.improvement.Teacher;

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
        int stuCount = teacher.clazzStudentCount();
        //班级总成绩
        double totalScore = teacher.clazzTotalScore();
        //班级平均成绩
        double averageScore = teacher.clazzAgerageScore();

        //组装对象，实际开发过程中会有对应的类
        Map<String,Object> mapObj = new HashMap<>();
        mapObj.put("班级", teacher.getClazz());
        mapObj.put("老师姓名", teacher.getName());
        mapObj.put("学生人数", stuCount);
        mapObj.put("总分", totalScore);
        mapObj.put("平均分", averageScore);
        return mapObj;
    }
    /**
     * 以上实现方式采用迪米特原则，校长直接调用老师类的接口，并获取相应的信息，整个逻辑功能非常清晰
     */
}
