package com.company;

import java.awt.event.KeyEvent;

//Rechtes Paddle
public class Paddle_rechts extends Paddles {

    private int x;
    private int y;
    private int dy;
    private int s=10; //s steht für speed

    public Paddle_rechts(){
        x=screensize.width/16+ screensize.width/16*14;
        y= screensize.height/2;

    }

    public void move(){
        y+=dy; //= y=y+dy;
    }

    public void changeSpeed(int speed){
        this.s=speed;
    }

    //Eingabe erkennen
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            dy = -s;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = s;
        }
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
