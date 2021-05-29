package com.javapong;

import java.awt.event.KeyEvent;

//Linkes Paddle
public class Paddle_links extends Paddles {

    private int x;
    private int y;
    private int dy;
    private int s=10; //s steht für speed

    public Paddle_links(){
    x=screensize.width/16;
    y=screensize.height/2;
    }

    //Eingabe erkennen
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            dy = -s;
        }
        if (key == KeyEvent.VK_S) {
            dy = s;
        }
    }
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            dy = 0;
        }
        if (key == KeyEvent.VK_S) {
            dy = 0;
        }
    }
    public void changeSpeed(int speed){
        this.s=speed;
    }
    public void move(){
        y+=dy; //= y=y+dy;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
