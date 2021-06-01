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
        if(xb>=screensize.width/2) {
            int d = yb - (y+ sh/32);
            if (d < 0) {   //Paddle muss nach oben
                dy = -s;
            }
            if (d > 0) {
                dy = s;
            }
            y += dy;
        }
    }
    public void changeSpeed(int speed){
            this.s = speed;

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

    public void setS(int s){
        this.s=s;
    }
}
