package com.mktb.nobug.io;

import com.mktb.nobug.GameCore.Cell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.FileHandler;

/*
文件格式为：
首行两个数字分别是行数r和列数c
剩余为 r * c 个 0 或 1
0表示第该位置初始为死，1表示初始为活
 */
public class Input {
    public static int[] getRowAndCol() {
        File file = new File("./src/com/mktb/nobug/input.txt");
        Scanner in = null;
        int[] a = new int[2];
        try {
            in = new Scanner(file);
            a[0] = in.nextInt();
            a[1] = in.nextInt();
            return a;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void getCells(Cell cell,int row, int col) {
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
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int status = in.nextInt();
                if (status == 1) {
                    cell.setCell(i, j, 1);
                } else {
                    cell.setCell(i, j, 0);
                }
            }
        }
    }
    public static void main(String[] args) {

    }
}
