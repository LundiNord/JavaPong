package com.javapong;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle_rechts_Bot extends Paddle_rechts {      //Bot

    private int x;
    private int y;
    private int y1;
    private int y2;
    private int y3;
    private int y4;
    private int y5;
    private int dy;
    private int xb;     //x,y des Balls
    private int yb;
    private int s=15; //s steht für speed
    private int sh; //screensize.height

    public Paddle_rechts_Bot(){
        sh= screensize.height;          //Paddle dimensionen festlegen
        x= (screensize.width/16)*15-getWidth();
        y=y1=screensize.height/2;
        y2=y1+sh/128;
        y3=y2+sh/8/4;
        y4=y3+sh/8*3/8;
        y5=y4+sh/8/4;
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
            y1+= dy;
            y2+=dy;
            y3+=dy;
            y4+=dy;
            y5+=dy;
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
    public Rectangle getBounds1(){
        return new Rectangle(x,y1,getWidth(),getHeight1());
    }
    public Rectangle getBounds2(){       //Neues Rectangel erzeugen für CollisionDetection
        return new Rectangle (x,y2,getWidth(),getHeight2());
    }
    public Rectangle getBounds3(){       //Neues Rectangel erzeugen für CollisionDetection
        return new Rectangle (x,y3,getWidth(),getHeight3());
    }
    public Rectangle getBounds4(){       //Neues Rectangel erzeugen für CollisionDetection
        return new Rectangle (x,y4,getWidth(),getHeight2());
    }
    public Rectangle getBounds5(){       //Neues Rectangel erzeugen für CollisionDetection
        return new Rectangle (x,y5,getWidth(),getHeight1());
    }
    public void setS(int s){
        this.s=s;
    }
}
