package com.yangtignjia.recursion;


/**
 * 杨廷甲
 * 2022-12-28
 */
public class MiGong {
    public static void main(String[] args) {

        //先创建一个二维数组模拟迷宫
        int[][] map = new int[8][7];
        //约定 使用1 为墙，先将上下置为墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //设置相应的挡板
        map[3][1] = 1;
        map[3][2] = 1;

        //输出地图
        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        //使用递归回溯给小球找路
        //setWay(map, 1, 1);
        setWay2(map, 1, 1);
        //打印走过的地图
        System.out.println("走过后地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * @param map 地图
     * @param i 表示从哪个地方开始的横坐标
     * @param j 表示从哪个地方开始的纵坐标
     * @return 如果找到map[6][5] 的位置 也就是通路就返回true 否则 false
     *
     * 约定： 当map[i][j] = 0 时就表名该点还没有走过
     *      当map[i][j] = 1 表示为墙
     *      当map[i][j] = 2 表示为通路可以走
     *      当map[i][j] = 3 表示该点已经走过 但是走不通
     * 在走迷宫时需要确定一个策略：
     *      1.下 - 右 - 上 - 左  如果该点走不通回溯
     *      2.
     */
    //适应递归回溯来给小球找路
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            //说明已经找到了
            return true;
        }else {
            if (map[i][j] == 0) {
                //如果当前该点还没有走过，就按照策略走
                map[i][j] = 2; //假定该点是可以走通的
                if (setWay(map, i + 1, j)) {
                    //向下走
                    return true;
                }else if (setWay(map, i, j + 1)) {
                    //向右走
                    return true;
                }else if (setWay(map, i - 1, j)) {
                    //向上走
                    return true;
                }else if (setWay(map , i,  j - 1)){
                    //先左走
                    return true;
                }else {
                    //说明走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            }else {
                //如果 已经走过 那可能是1：墙 或者2： 通路 或者3：死路
                return false;
            }
        }
    }


    //修改找路策略：是上 - 右 - 下 - 左
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            //说明已经找到了
            return true;
        }else {
            if (map[i][j] == 0) {
                //如果当前该点还没有走过，就按照策略走
                map[i][j] = 2; //假定该点是可以走通的
                if (setWay2(map, i - 1, j)) {
                    //向下走
                    return true;
                }else if (setWay2(map, i, j + 1)) {
                    //向右走
                    return true;
                }else if (setWay2(map, i + 1, j)) {
                    //向上走
                    return true;
                }else if (setWay2(map , i,  j - 1)){
                    //先左走
                    return true;
                }else {
                    //说明走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            }else {
                //如果 已经走过 那可能是1：墙 或者2： 通路 或者3：死路
                return false;
            }
        }
    }
}
