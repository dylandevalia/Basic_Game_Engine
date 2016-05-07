package com.game.main;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Overlord Main on 07/05/2016.
 */
public class Walls extends Game_Object {

    BufferedImage wall = null;

    public Walls(int x, int y, ID id, BufferedImage wall){
        super(x,y,id,wall);

        this.wall = wall;

    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(wall, x, y, wall.getWidth(), wall.getHeight() / 2, null);
    }

}
