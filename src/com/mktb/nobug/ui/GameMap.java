package com.mktb.nobug.ui;

import com.mktb.nobug.GameCore.Cell;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.JButton;


public class GameMap {
   private JButton[][] map;
   private int row;
   private int col;

   GameMap(int rows, int cols, Cell cell) {
       row = rows;
       col = cols;
       map = new JButton[rows][cols];
       for (int i = 0; i < rows; i++) {
           for (int j = 0; j < cols; j++) {
               map[i][j] = new JButton();
               map[i][j].setMargin(new Insets(0, 0, 0, 0));
               if (cell.getCell(i, j) == 1) {
                   map[i][j].setBackground(Color.black);
               } else {
                   map[i][j].setBackground(Color.white);
               }
            }
        }
   }

   public JButton getMap(int i, int j) {
       return map[i][j];
   }

   /**
    * 更新GUI界面细胞颜色.
    * @param cell 当前细胞矩阵
    */ 
   public void freshMap(Cell cell) {
       for (int r = 0; r < row; r++) {
           for (int c = 0; c < col; c++) {
               if (cell.getCell(r, c) == 1) {
                   map[r][c].setBackground(Color.black);
               } else {
                   map[r][c].setBackground(Color.white);
               }
           }
       }
   }
}
