package com.mktb.nobug.GameCore;

public class Cell {
    private int[][] cellArray;
    private int[][] neighbors;
    private int row;
    private int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        cellArray = new int[row][col];
        neighbors = new int[row][col];
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getCell(int x, int y) {
        if(x >= 0 && x <row && y>=0 && y<col)
            return cellArray[x][y];
        return -1;
    }

    public void setCell(int x,int y,int cell) {
        this.cellArray[x][y]=cell;
    }

    public void freshNeighbors() {
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (r - 1 >= 0 && c - 1 >= 0 && cellArray[r - 1][c - 1] == 1) {
                    neighbors[r][c]++;
                }
                if (r - 1 >= 0 && cellArray[r - 1][c] == 1) {
                    neighbors[r][c]++;
                }
                if (r - 1 >= 0 && c + 1 < col && cellArray[r - 1][c + 1] == 1) {
                    neighbors[r][c]++;
                }
                if (c - 1 >= 0 && cellArray[r][c - 1] == 1) {
                    neighbors[r][c]++;
                }
                if (c + 1 < col && cellArray[r][c + 1] == 1) {
                    neighbors[r][c]++;
                }
                if (r + 1 < row && c - 1 >= 0 && cellArray[r + 1][c - 1] == 1) {
                    neighbors[r][c]++;
                }
                if (r + 1 < row && cellArray[r + 1][c] == 1) {
                    neighbors[r][c]++;
                }
                if (r + 1 < row && c + 1 < col && cellArray[r + 1][c + 1] == 1) {
                    neighbors[r][c]++;
                }
            }
        }
    }

    public int[][] getNeighbors() {
        freshNeighbors();
        return neighbors;
    }
}
