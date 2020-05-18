package com.mktb.nobug.ui;

import com.mktb.nobug.GameCore.GameService;
import com.mktb.nobug.GameCore.Cell;
import com.mktb.nobug.io.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class MainFrame extends JFrame {
    private GameMap gameMap;
    private JPanel allPanel;
    private JPanel gridPanel;
    private JPanel rowColPanel;
    private JPanel gnerationPanel;
    private Container container;
    private int row;
    private int col;
    private Cell cell;
    private int generation = 0;
    private static int flag = 0;       //标志随机输入还是文件输入


    public static void main(String[] args) {
        firstFrame frame = new firstFrame("输入大小（不输入则默认为input.txt为输入）");
        frame.setVisible(true);
    }

    private static class firstFrame extends JFrame{
        private JPanel mainPanel;
        private Container container;
        firstFrame(String title) {
            super(title);

            setLocation(500, 200);
            setSize(500, 100);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            mainPanel = new JPanel();
            container = getContentPane();

            JLabel label_row = new JLabel("细胞行数");
            JTextField textField_row = new JTextField(5);

            JLabel label_col = new JLabel("细胞列数");
            JTextField textField_col = new JTextField(5);

            JButton button = new JButton("确定");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String rows = textField_row.getText();
                    String cols = textField_col.getText();

                    int row;
                    int col;
                    if (rows.equals("") || cols.equals("")) {
                            int[] a = Input.getRowAndCol();
                            row = a[0];
                            col = a[1];
                            flag = 1;
                    } else {
                        row = Integer.parseInt(rows);
                        col = Integer.parseInt(cols);
                    }

                    firstFrame.this.setVisible(false);
                    MainFrame mainFrame = new MainFrame(row, col);
                    mainFrame.init();
                }
            });

            mainPanel.add(label_row);
            mainPanel.add(textField_row);
            mainPanel.add(label_col);
            mainPanel.add(textField_col);
            mainPanel.add(button);

            container.add(mainPanel);
        }
    }

    MainFrame(int rows, int cols) {
        super("生命游戏");

        row = rows;
        col = cols;
        setLocation(500, 200);
        setSize(30 * col, 30 * row);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container = getContentPane();
    }

    public void init() {
        allPanel = new JPanel();
        gridPanel = new JPanel();
        rowColPanel = new JPanel();
        gnerationPanel = new JPanel();
        allPanel.setLayout(new BorderLayout(0, 0));
        gridPanel.setLayout(new GridLayout(row, col, 0, 0));

        JLabel label_row = new JLabel("细胞组行数" + row);
        JLabel label_col = new JLabel("细胞组列数" + col);

        final JLabel lableGneration = new JLabel("繁衍代数");
        rowColPanel.add(label_row);
        rowColPanel.add(label_col);

        gnerationPanel.add(lableGneration);
        allPanel.add(rowColPanel, BorderLayout.NORTH);
        allPanel.add(gnerationPanel, BorderLayout.SOUTH);

        container.add(allPanel, BorderLayout.NORTH);
        container.add(gridPanel, BorderLayout.CENTER);


        cell = GameService.initMap(row, col, flag);

        gameMap = new GameMap(row, col, cell);
        generation = 1;
        lableGneration.setText("繁衍代数" + generation);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                gridPanel.add(gameMap.getMap(i, j));
            }
        }

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                cell = GameService.nextWorld(cell);
                ++generation;
                lableGneration.setText("繁衍代数" + generation);
                gameMap.freshMap(cell);

                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        if (cell.getCell(i, j) == 1) {
                            gameMap.getMap(i, j).setBackground(Color.black);
                        } else {
                            gameMap.getMap(i, j).setBackground(Color.white);
                        }
                    }
                }
            }
        }, 1000, 500);
        setVisible(true);
    }
}
