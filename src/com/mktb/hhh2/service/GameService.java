package com.mktb.hhh2.service;

import com.mktb.hhh2.data.CellArray;
import com.mktb.hhh2.data.CellState;

import java.util.Random;
import javax.swing.JFrame;


public class GameService {
//	private static int rows;
//	private static int cols;

    public static int[] temp= {-1,0,1};
    /*初始化随机*/
    public static CellArray initMap(int row,int col ) {
        CellArray cells=new CellArray(row,col);
        for(int  i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                Random r=new Random();
                int a=r.nextInt(4);
                if(a==1) {
                    cells.setCell(i,j,CellState.LIVE.getValue());
                }
                else {
                    cells.setCell(i,j,CellState.DEAD.getValue());

                }
            }
        }
        return cells;
    }

    public static CellArray generate(CellArray cells) {
        CellArray nextCells=new CellArray(cells.getRow(),cells.getCol());
        for(int i=0;i<nextCells.getRow();i++)
            for(int j=0;j<nextCells.getCol();j++) {

                int count=countNumber(cells,i,j);
                if(count==3) {
                    nextCells.setCell(i, j, CellState.LIVE.getValue());
                }
                else if(count==2&&cells.getCell(i, j)==CellState.LIVE.getValue()) {
                    nextCells.setCell(i, j, CellState.LIVE.getValue());
                }
                else {
                    nextCells.setCell(i, j, CellState.DEAD.getValue());
                }
            }


        return  nextCells;

    }


    public static int countNumber(CellArray cells,int x,int y) {
        int count = 0;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (CellState.LIVE.getValue() == cells.getCell(x + temp[i], y + temp[j])) {
                    ++count;
                }
            }
        }
        if (CellState.LIVE.getValue() == cells.getCell(x, y)) {
            --count;
        }

        return count;
    }
}