package com.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Overlord Main on 06/05/2016.
 */
public class KeyInput extends KeyAdapter{

    private Handler handler;

    public KeyInput(Handler handler){
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if(getFreeze())
            return;

        for(int i = 0; i < handler.object.size(); i++){
            Game_Object tempObject = handler.object.get(i);
            if(tempObject.getID() == ID.Player_2){
                if(key == KeyEvent.VK_UP){
                    moveUp(tempObject);
                } else if(key == KeyEvent.VK_DOWN){
                    moveDown(tempObject);
                } else if(key == KeyEvent.VK_LEFT){
                    moveLeft(tempObject);
                } else if(key == KeyEvent.VK_RIGHT){
                    moveRight(tempObject);
                }
            }
            if(tempObject.getID() == ID.Player_1){
                if(key == KeyEvent.VK_W){
                    moveUp(tempObject);
                } else if(key == KeyEvent.VK_S){
                    moveDown(tempObject);
                } else if(key == KeyEvent.VK_A){
                    moveLeft(tempObject);
                } else if(key == KeyEvent.VK_D){
                    moveRight(tempObject);
                }
            }

        }

        Debug.print(2,"Key Pressed: " + key);
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        Debug.print(2, "Key Released: " + key);
    }

    public void moveUp(Game_Object tempObject){
        tempObject.setY(tempObject.getY() - 5);
    }

    public void moveDown(Game_Object tempObject){
        tempObject.setY(tempObject.getY() + 5);
    }

    public void moveLeft(Game_Object tempObject){
        tempObject.setX(tempObject.getX() - 5);
    }

    public void moveRight(Game_Object tempObject){
        tempObject.setX(tempObject.getX() + 10);
    }

    boolean Freeze = false;

    public void setFreeze(boolean setFreeze){
        Freeze = setFreeze;
    }

    public boolean getFreeze(){
        return Freeze;
    }

}
