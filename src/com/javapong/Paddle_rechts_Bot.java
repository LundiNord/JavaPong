package com.javapong;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle_rechts_Bot extends Paddle_rechts {      //Bot

    private int x;
    private int y;
    private int dy;
    private int xb;     //x,y des Balls
    private int yb;
    private int s=15; //s steht für speed
    private int sh; //screensize.height
    Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    //das vom Bot im Einzelspieler kontrollierte Paddle

    public Paddle_rechts_Bot(){
        sh= screensize.height;          //Paddle dimensionen festlegen
        x= (screensize.width/16)*15-getWidth();
        y= screensize.height/2;
    }

    public void move(){
        if(xb>=screensize.width/2) {    //Wenn der Ball in der eigenen Hälfte ist
            int d = yb - (y+ sh/32);    //zum Ball bewegen
            if (d < 0) {   //Paddle muss nach oben
                dy = -s;
            }
            if (d > 0) {   //nach unten
                dy = s;
            }
            y += dy;
        }
    }
    public void changeSpeed(int speed){
        this.s = speed;
    }
    public void keyPressed(KeyEvent e) {        //Leer, weil kompatibel mit Paddle_rechts
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
