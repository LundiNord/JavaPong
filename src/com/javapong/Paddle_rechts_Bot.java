package com.javapong;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.*;

public class Paddle_rechts_Bot extends Paddle_rechts {

    private int x;
    private int y;
    private int dy;
    private int xb;
    private int yb;
    private int s=15; //s steht für speed
    private int sh; //screensize.height
    public Paddle_rechts_Bot(){
        sh= screensize.height;
        x= (screensize.width/16)*15-getWidth();
        y= screensize.height/2;
    }

    public void move(){
        if(y>0 && y+getHeight()<sh) {           //Paddle darf nicht aus dem Bildschirm
            y = yb;
        }
        else if(y<10){
            y = 1;
        }
        else {
            y = sh-getHeight()-1;
        }
    }
    public void changeSpeed(int speed){
        this.s=speed;
    }
    //Eingabe erkennen
    public void keyPressed(KeyEvent e) {
    }
    public void keyReleased(KeyEvent e) {
    }

    public void setXbYb(int xb, int yb){
        this.xb=xb;
        this.yb=yb;
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
}
