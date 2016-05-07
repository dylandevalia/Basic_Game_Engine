package com.game.main;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Overlord Main on 07/05/2016.
 */
public class Background extends Game_Object {

    BufferedImage background = null;

    public Background(int x, int y, ID id, BufferedImage background){
        super(x,y,id,background);

        this.background = background;

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(background, 0, 0, background.getWidth(), background.getHeight() / 2, null);
    }


}
