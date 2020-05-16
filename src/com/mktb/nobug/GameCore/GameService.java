package com.mktb.nobug.GameCore;

import com.mktb.nobug.io.Input;

import java.util.Random;

public class GameService {

    //随机生成图像
    public static Cell initMap(int row, int col,int flag) {
        Cell cell = new Cell(row, col);
        if (flag == 1) {
            Input.getCells(cell, row, col);
        } else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    Random ran = new Random();
                    int status = ran.nextInt(4);
                    if (status == 1) {
                        cell.setCell(i, j, 1);
                    } else {
                        cell.setCell(i, j, 0);
                    }
                }
            }
        }

        return cell;
    }

    public static Cell nextWorld(Cell cell) {
        Cell nextCell = new Cell(cell.getRow(), cell.getCol());
        int[][] neighbors = cell.getNeighbors();
        for (int r = 0; r < nextCell.getRow(); r++) {
            for (int c = 0; c < nextCell.getCol(); c++) {
                if (neighbors[r][c] == 3) {
                    nextCell.setCell(r, c, 1);
                } else if (neighbors[r][c] == 2 && cell.getCell(r, c) == 1) {
                    nextCell.setCell(r, c, 1);
                } else {
                    nextCell.setCell(r, c, 0);
                }
            }
        }
        return nextCell;
    }
}
