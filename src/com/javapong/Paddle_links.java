package com.javapong;

import java.awt.*;
import java.awt.event.KeyEvent;

//Linkes Paddle
public class Paddle_links extends Paddles {

    private int x;
    private int y;
    private int dy;
    private int s=10; //s steht für speed
    private int sh; //screensize.height

    public Paddle_links(){
    sh= screensize.height;
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
        if(y>0 && y<sh) {           //Paddle darf nicht aus dem Bildschirm
            y = y + (dy); //= y=y+dy;
        }
        else if(y<10){
            y = 1;
        }
        else {
            y = sh-1;
        }
    }
    // Neues Rectangel erzeugen für CollisionDetection
    public Rectangle getBounds(){
        return new Rectangle(x,y,getWidth(),getHeight());
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
