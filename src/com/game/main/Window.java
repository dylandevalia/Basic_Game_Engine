package com.game.main;

import java.awt.Dimension;

import javax.swing.JFrame;
import java.awt.Canvas;
/**
 * Created by Overlord Main on 06/05/2016.
 */
public class Window extends Canvas{

    //private static final long serialVersionUID;

    public Window(int width, int height, String title, Game Game){

        JFrame Game_Canvas = new JFrame(title);

        Game_Canvas.setPreferredSize((new Dimension(width, height)));
        Game_Canvas.setMaximumSize((new Dimension(width, height)));
        Game_Canvas.setMinimumSize((new Dimension(width, height)));

        Game_Canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Game_Canvas.setResizable(false);
        Game_Canvas.setLocationRelativeTo(null);
        Game_Canvas.add(Game);
        Game_Canvas.setVisible(true);
        Game.start();

    }

}
