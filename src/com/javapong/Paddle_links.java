package com.javapong;

import java.awt.*;
import java.awt.event.KeyEvent;

//Linkes Paddle
public class Paddle_links extends Paddles {

    private int x;
    private int y;
    private int y1;
    private int y2;
    private int y3;
    private int y4;
    private int y5;
    private int dy;
    private int s=15; //s steht für speed
    private int sh; //screensize.height

    public Paddle_links(){
    sh= screensize.height;
    x= screensize.width/16;
        y=y1=screensize.height/2;
        y2=y1+sh/128;
        y3=y2+sh/8/4;
        y4=y3+sh/8*3/8;
        y5=y4+sh/8/4;
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
        if(y>0 && y+getHeight()<sh) {           //Paddle darf nicht aus dem Bildschirm
            y += dy;
            y1+= dy;
            y2+=dy;
            y3+=dy;
            y4+=dy;
            y5+=dy;
        }
        else if(y<10){
            y = 1;
            y1=1;
            y2=y1+sh/128;
            y3=y2+sh/8/4;
            y4=y3+sh/8*3/8;
            y5=y4+sh/8/4;
        }
        else {
            y=y1=sh-getHeight()-1;
            y2=y1+sh/128;
            y3=y2+sh/8/4;
            y4=y3+sh/8*3/8;
            y5=y4+sh/8/4;
        }
    }
    public int getY2(){
        return y2;
    }
    public int getY3(){
        return y3;
    }
    public int getY4(){
        return y4;
    }
    public int getY5(){
        return y5;
    }
    public Rectangle getBounds2(){       //Neues Rectangel erzeugen für CollisionDetection
        return new Rectangle (x,y2,getWidth(),getHeight1());
    }
    public Rectangle getBounds3(){       //Neues Rectangel erzeugen für CollisionDetection
        return new Rectangle (x,y3,getWidth(),getHeight2());
    }
    public Rectangle getBounds4(){       //Neues Rectangel erzeugen für CollisionDetection
        return new Rectangle (x,y4,getWidth(),getHeight3());
    }
    public Rectangle getBounds5(){       //Neues Rectangel erzeugen für CollisionDetection
        return new Rectangle (x,y5,getWidth(),getHeight2());
    }
    public Rectangle getBounds1(){           // Neues Rectangel erzeugen für CollisionDetection
        return new Rectangle(x,y1,getWidth(),getHeight());
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
