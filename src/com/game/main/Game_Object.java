package com.game.main;

import java.awt.*;

/**
 * Created by Overlord Main on 06/05/2016.
 */
public abstract class Game_Object {

    /** Protected means that the instance of each class can only access their
     * instance of that variable */
    protected int x, y;
    protected ID id;
    protected int velX, velY;


    public Game_Object(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setID(ID id){
        this.id = id;
    }

    public void setvelX(int velX){
        this.velX = velX;
    }

    public void setvelY(int velY){
        this.velY = velY;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public ID getID(){
        return id;
    }

    public int getvelX(){
        return velX;
    }

    public int getvelY(){
        return velY;
    }


}
