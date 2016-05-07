package com.game.main;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Overlord Main on 06/05/2016.
 */
public class Game_Loop {

    public Game_Loop(boolean running, Game Game,Handler handler) {

        long timer = System.currentTimeMillis();
        long lastTime = System.nanoTime();

        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        int frames = 0;

        while(running){

            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                Game.tick();
                delta--;
            }

            if(running){
                Game.render();
            }

            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                Debug.print(0, "FPS: " + frames);
                frames = 0;
            }
        }
        Game.stop();
    }





}
