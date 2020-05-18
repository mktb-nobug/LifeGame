package com.mktb.nobug.GameCore;

import com.mktb.nobug.io.Input;

public class GameService {

    /**
     * 生成图像.
     * @param row 行数
     * @param col 列数
     * @param flag =0为随即输入，=1为文件输入
     * @return
     */
    public static Cell initMap(int row, int col, int flag) {
        Cell cell = new Cell(row, col);
        if (flag == 1) {
            Input.getCellsFromeFile(cell, row, col);
        } else {
            Input.getCellsRandom(cell, row, col);
        }

        return cell;
    }

    /**
     * 根据邻居矩阵获取下一代.
     * @param cell 当前细胞矩阵
     * @return
     */
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
