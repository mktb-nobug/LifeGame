package com.mktb.nobug.io;

import com.mktb.nobug.GameCore.Cell;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/*
文件格式为：
首行两个数字分别是行数r和列数c
剩余为 r * c 个 0 或 1
0表示第该位置初始为死，1表示初始为活
 */
public class Input {

    /**
     * 获取文件输入的行数和列数.
     * @return
     */
    public static int[] getRowAndCol() {
        File file = new File("./src/com/mktb/nobug/input.txt");
        Scanner in = null;
        int[] a = new int[2];
        try {
            in = new Scanner(file);
            a[0] = in.nextInt();
            a[1] = in.nextInt();
            in.close();
            return a;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从文件读取，并初始化第一代细胞.
     * @param cell 待初始化的细胞矩阵
     * @param row 行数
     * @param col 列数
     */
    public static void getCellsFromeFile(Cell cell, int row, int col) {
        File file = new File("./src/com/mktb/nobug/input.txt");
        Scanner in = null;
        int[] a = new int[2];
        try {
            in = new Scanner(file);
            a[0] = in.nextInt();
            a[1] = in.nextInt();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int status;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                status = in.nextInt();
                if (status == 1) {
                    cell.setCell(i, j, 1);
                } else {
                    cell.setCell(i, j, 0);
                }
            }
        }
    }
    
    /**
     * 随机初始化第一代细胞.
     * @param cell 待初始化的细胞矩阵
     * @param row 行数
     * @param col 列数
     */
    public static void getCellsRandom(Cell cell, int row, int col) {
        int status;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Random ran = new Random();
                status = ran.nextInt(4);
                if (status == 1) {
                    cell.setCell(i, j, 1);
                } else {
                    cell.setCell(i, j, 0);
                }
            }
        }
    }
}
