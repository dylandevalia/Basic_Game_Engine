package com.game.main;

import java.awt.*;

/**
 * Created by Overlord Main on 06/05/2016.
 */
public class Player extends Game_Object{

    boolean bounceX = false;
    boolean bounceY = false;



    public Player(int x, int y, ID id){
        super(x,y,id);
    }

    @Override
    public void tick() {
        if(isXedge(getX())){
            Debug.print(1,"X Wall Found At:" + y );
            if(getX() + 42 >= Game.WIDTH){
                velX = -5;
            } else {
                velX = 5;
            }
        } else if (isYedge(getY())){
            Debug.print(1,"Y Wall Found At:" + x );
            if(getY() + 52 >= Game.HEIGHT){
                velY = -5;
            } else {
                velY = 5;
            }
        } else {
        }
        x += velX;
        y += velY;

    }

    @Override
    public void render(Graphics g) {
        if(id == ID.Player_1)
            g.setColor(Color.CYAN);

        if(id == ID.Player_2)
            g.setColor(Color.WHITE);

        if(id == ID.Enemy)
            g.setColor(Color.RED);

        g.fillRect(x,y,32,32);
    }

    public boolean isXedge(int x){
        if(x <= 10 || x + 42 >= Game.WIDTH){
            return true;
        }
        return false;
    }

    public boolean isYedge(int y){
        if(y <= 10 || y + 52 >= Game.HEIGHT){
            return true;
        }
        return false;
    }
}
