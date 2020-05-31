package com.mktb.nobug.GameCore;

import com.mktb.nobug.io.Input;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {

    private Cell cell;

    @Before
    public void setUp() throws Exception {
        cell = new Cell(10, 10);
        Input.getCellsFromFile("./src/com/mktb/nobug/input.txt", cell, 10, 10);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getRow() {
        int row = cell.getRow();
        assertEquals(10, row);
    }

    @Test
    public void getCol() {
        int col = cell.getCol();
        assertEquals(10, col);
    }

    @Test
    public void setRow() {
        cell.setRow(20);
        assertEquals(20, cell.getRow());
    }

    @Test
    public void setCol() {
        cell.setCol(20);
        assertEquals(20, cell.getCol());
    }

    @Test
    public void getCell() {
        int i = cell.getCell(1, 1);
        assertEquals(1, i);
    }

    @Test
    public void setCell() {
        cell.setCell(1, 1, 0);
        assertEquals(0, cell.getCell(1, 1));
    }

    @Test
    public void freshNeighbors() {
        int[][] a = cell.getNeighbors();
        int[][] exp = {
                {3, 3, 2, 0, 0, 0, 0, 0, 0, 0},
                {3, 3, 2, 0, 0, 0, 0, 0, 0, 0},
                {2, 2, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 2, 2},
                {0, 0, 0, 0, 0, 0, 0, 2, 2, 2},
                {0, 0, 0, 0, 0, 0, 0, 2, 2, 3}
        };
        assertArrayEquals(exp, a);
    }

    @Test
    public void getNeighbors() {
        int[][] a = cell.getNeighbors();
        int[][] exp = {
                {3, 3, 2, 0, 0, 0, 0, 0, 0, 0},
                {3, 3, 2, 0, 0, 0, 0, 0, 0, 0},
                {2, 2, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 2, 2},
                {0, 0, 0, 0, 0, 0, 0, 2, 2, 2},
                {0, 0, 0, 0, 0, 0, 0, 2, 2, 3}
        };
        assertArrayEquals(exp, a);
    }

    @Test
    public void getCells() {
        int[][] a = cell.getCells();
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
        assertArrayEquals(exp, a);
    }
}