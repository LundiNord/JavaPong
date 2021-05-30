package com.javapong;

import java.awt.*;
import java.util.Random;

public class Ball  {

    private int x;
    private int y;
    //private int xo;         //x old
    //private int yo;         //y old
    private int dx;
    private int dy;
    private int width;
    private int height;
    private int defaultSpeed = 10;

    //Kann Bildschirmgröße lesen
    Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public Ball(){
        width= screensize.width/48;
        height= width;
        Startposition();
        startBall();
    }

    public void Startposition(){        //Startposition festlegen
        y= screensize.height/2;
        x= screensize.width/2- screensize.width/96;
    }
    public void changeballsize(int dc){
        width= screensize.width/32+dc;
        height= screensize.height/32+dc;
    }
    public Rectangle getBounds(){           // Neues Rectangel erzeugen für CollisionDetection
        return new Rectangle(x,y,getWidth(),getHeight());
    }
    public void move(){
        x+=dx;
        y+=dy;
    }
    public void AbprallenPaddle(){
        dx=-dx;         //x dreht sich
        dy=dy;          //y nicht
    }
    public void AbprallenBoarder(){
        dx=dx;          //x dreht sich nicht
        dy=-dy;         //y schon
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getWidth(){
         return width;
    }
    public int getHeight(){
        return height;
    }
    public int getDx(){
        return dx;
    }
    public int getDy(){
        return dy;
    }
    public void startBall() {       //Ball fliegt zufällig los
        int d = new java.util.Random().nextInt(5);
        if(d==1) {
            dx = defaultSpeed;
            dy = defaultSpeed;
        }
        else if(d==2) {
            dx = -defaultSpeed;
            dy = -defaultSpeed;
        }
        else if(d==3) {
            dx = -defaultSpeed;
            dy = defaultSpeed;
        }
        else {
            dx = defaultSpeed;
            dy = -defaultSpeed;
        }
    }
    public void resetBall(boolean links) {
        int d = new java.util.Random().nextInt(3);
        if(links==true) {
            Startposition();
            wait(100);
            if(d==1) {
                dx = -defaultSpeed;
                dy = defaultSpeed;
            }
            else {
                dx = -defaultSpeed;
                dy = -defaultSpeed;
            }
        }
        else {
            Startposition();
            wait(100);
            if(d==1) {
                dx = defaultSpeed;
                dy = -defaultSpeed;
            }
            else {
                dx = defaultSpeed;
                dy = defaultSpeed;
            }
        }
    }

    public void Speedincrease(){
        defaultSpeed=defaultSpeed+2;
    }

    public static void wait(int ms)     //Warten Methode
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}