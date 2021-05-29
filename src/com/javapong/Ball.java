package com.javapong;

import java.awt.*;

public class Ball {

    private int x;
    private int y;
    private int dx;
    private int dy;
    private int width;
    private int heigth;
    private int s; // s steht für speed
    private int c; //Größenänderung des Balls

    //Startposition festlegen (muss nach jedem Punkt ausgeführt werden)
    public void Startposition(){
        y= screensize.height/2;
        x= screensize.width/2;
    }

    public void changespeed(){
        dx+=s;
        dy+=s;
    }

    //Kann Bildschirmgröße lesen
    Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public Ball(){
        width= screensize.width/32;
        heigth= screensize.height/32;
    }

    public void changeballsize(){
        width= screensize.width/32+c;
        heigth= screensize.height/32+c;
    }

    public void move(){
        x+=dx;
        y+=dy;
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
    public int getHeigth(){
        return heigth;
    }
    public int getDx(){
        return dx;
    }
    public int getDy(){
        return dy;
    }
    public int getS(){
        return s;
    }



}
