package com.javapong;

import java.awt.*;
import java.awt.event.KeyEvent;

public class OPaddle_links extends OPaddles{
    private int x;
    private int y;
    private int dy;
    private int s=15; //s steht für speed

    public OPaddle_links(){
            x=200;
            y=425;
    }

    public void move(){
            y += dy;
    }
    public void changeSpeed(int speed){
        this.s = speed;
    }
    public void keyPressed(KeyEvent e) {        //Leer, weil kompatibel mit Paddle_links
    }
    public void keyReleased(KeyEvent e) {
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Rectangle getBounds(){       //Neues Rectangel erzeugen für CollisionDetection
        return new Rectangle(x,y,getWidth(),getHeight());
    }
    public void setS(int s){
        this.s=s;
    }
}
