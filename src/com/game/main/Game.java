package com.game.main;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Overlord Main Edit  on 06/05/2016.
 */
public class Game extends Canvas implements Runnable{

    //private Debug debug;
    private Handler handler;


    //public static final int WIDTH = 640;
    //public static final int HEIGHT = WIDTH / 12 * 9;

    public static final int WIDTH = 1024;
    public static final int HEIGHT = WIDTH / 2;

    private boolean running = false;

    BufferedImage background = null;
    BufferedImage ground = null;

    public Game(){
        new Window(WIDTH, HEIGHT, "Lets Fuck Shit Up", this);
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));

        try {
            background = ImageIO.read(new File("res/sky.jpg"));
            ground = ImageIO.read(new File("res/ground_1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        handler.addObject(new Background(0,0,ID.Skybox,background));


        //handler.addObject(new Background(0,0,ID.Wall,ground));

        handler.addObject(new Player(100,100,ID.Player_1));
        handler.addObject(new Player(200,200,ID.Player_2));
        handler.addObject(new Player(200,200,ID.Enemy));

        handler.addObject(new Walls(0,HEIGHT - 150,ID.Wall,ground));
        handler.addObject(new Walls(433,HEIGHT - 150,ID.Wall,ground));
        handler.addObject(new Walls(866,HEIGHT - 150,ID.Wall,ground));



        /**
        Random rand = new Random();
        for(int i = 0; i < 40 ; i++){
            int  x = rand.nextInt(WIDTH) + 1;
            int  y = rand.nextInt(HEIGHT) + 1;
            handler.addObject(new Player(x,y,ID.Player_1));
        }*/

    }

    /**
     * the thread being created here refers the instance of this particular class.
     * then assigns the start method to the thread so the game will run within that class.
     */
    private Thread thread;

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    /** this method will kill the thread using the .join method and will reset the boolean
     * running state to false.
     */
    public synchronized  void stop(){
        try{
            thread.join();
            running = false;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    void tick(){
        handler.tick();
    }


    void render() {
        BufferStrategy bs = getBufferStrategy();

        if(bs == null){
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH,HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }

    Game_Loop Game_Loop;

    public void run(){

        new Game_Loop(running,this,handler);

    }


    public static void main(String args[]){
        new Game();
    }

    public void wait(int period) {
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


    int cc1 = 0, cc2 = 0, cc3 = 0;
    public Color Background_Colour(){
        Color background = new Color(0,0,0);

        if(cc1 < 256){
            if(cc2 < 256){
                if(cc3 < 256){
                    background = new Color(cc1,cc2,cc3);
                    cc3 += 10;
                    return background;
                }
                cc3 = 0;
                cc2 += 10;
            }
            cc2 = 0;
            cc1 += 10;
        }
        cc1 = 0;

        return background;
    }

}
