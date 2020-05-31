package com.mktb.nobug.ui;

import com.mktb.nobug.GameCore.Cell;
import com.mktb.nobug.GameCore.GameService;
import com.mktb.nobug.io.Input;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.Assert.*;

public class GameMapTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getMap() {
        Cell cell = GameService.initMap("./src/com/mktb/nobug/input.txt", 10, 10, 1);
        JButton exp = new JButton();
        exp.setBackground(Color.black);
        GameMap gameMap = new GameMap(10, 10, cell);
        assertEquals(exp.getColorModel(), gameMap.getMap(1, 1).getColorModel());
    }

    @Test
    public void freshMap() {
        JButton exp = new JButton();
        exp.setBackground(Color.black);
        Cell cell = GameService.initMap("./src/com/mktb/nobug/input.txt", 10, 10, 1);
        GameMap gameMap = new GameMap(10, 10, cell);
        Cell nextCell = GameService.nextWorld(cell);
        gameMap.freshMap(nextCell);
        assertEquals(exp.getColorModel(), gameMap.getMap(9, 9).getColorModel());
    }
}