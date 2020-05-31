package com.mktb.nobug.io;

import com.mktb.nobug.GameCore.Cell;

import static org.junit.Assert.*;

public class InputTest {

    @org.junit.Test
    public void getRowAndCol() {
        int[] a = new int[2];
        String str = "./src/com/mktb/nobug/input.txt";
        a = Input.getRowAndCol(str);
        int[] get = {10, 10};
        assertArrayEquals(get, a);
    }

    @org.junit.Test
    public void getCellsFromeFile() {
        int[] a = new int[2];
        String str = "./src/com/mktb/nobug/input.txt";
        a = Input.getRowAndCol(str);
        Cell cell = new Cell(a[0], a[1]);
        Input.getCellsFromFile(str, cell, a[0], a[1]);
        int[][] res = cell.getCells();
        int[][] exp = {
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0}
        };
        assertArrayEquals(exp, res);
    }

    @org.junit.Test
    public void getCellsRandom() {
        int flag = 0;
        Cell cell = new Cell(20, 20);
        Input.getCellsRandom(cell, 20, 20);
        outer:
        for (int[] a : cell.getCells()) {
            for (int c : a) {
                if (c != 0) {
                    assert true;
                    flag = 1;
                    break outer;
                }
            }
        }
        assert flag != 0;
    }
 }