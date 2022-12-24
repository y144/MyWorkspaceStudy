package com.yangtignjia.datastructures.sparsearray;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * 杨廷甲
 * 2022-10-01
 */
public class SparseArray {
    public static void main(String[] args) {
        //先创建一个二维数组 11 * 11
        //0:表示没有棋子 1：表示黑子 2：表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //输出 原始的二维数组
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将二维数组 转 稀疏数组
        //1.先遍历二维数组得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        // 创建对用的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        // 给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //遍历二维数组将非0数据存入稀疏数组
        int count = 0; //用于记录时第几个非0数据
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        //输出稀疏数组
        System.out.println();
        System.out.println("得到的稀疏数组为如下形式");
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //保存到磁盘
        File file = new File("F:\\MyWorkspace\\Exercise_01.dat");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            objectOutputStream.writeObject(sparseArr);
        } catch (Exception e) {
            System.out.println("保存文件异常" + e);
        }

        //将稀疏数组 转为二维数组
        //1.先读取稀疏数组的第一行，确定二维数组的大小，创建二维数组
        int row = sparseArr[0][0];
        int column = sparseArr[0][1];
        int cheseArr2[][] = new int[row][column];

        //遍历稀疏数组将数据赋值给二维数组
        for (int i = 1; i < sparseArr.length; i++) {
            int rowt = sparseArr[i][0];
            int col = sparseArr[i][1];
            int value = sparseArr[i][2];
            cheseArr2[rowt][col] = value;
        }

        //打印返回后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组---");
        for (int[] ints : cheseArr2) {
            for (int data : ints) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
