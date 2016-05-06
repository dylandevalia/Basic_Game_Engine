package com.game.main;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Overlord Main on 06/05/2016.
 */
public class Handler {

    final LinkedList<Game_Object> object = new LinkedList<>();

    public void tick(){

        if(object.size() == 0){
            return;
        }

        for(int i = 0; i < object.size(); i++){
            Game_Object tempObject = object.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g){

        if(object.size() == 0){
            return;
        }

        for(int i = 0; i < object.size(); i++){
            Game_Object tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    public void addObject(Game_Object object){
        this.object.add(object);
    }

    public void removeObject(Game_Object object){
        this.object.remove(object);
    }

}
