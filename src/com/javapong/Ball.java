package com.javapong;

import java.awt.*;

public class Ball  {

    private int x;
    private int y;
    private int dx=2;
    private int dy=2;
    private int width;
    private int height;

    //Kann Bildschirmgröße lesen
    Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public Ball(){
        width= screensize.width/48;
        height= width;
        Startposition();
    }

    //Startposition festlegen (muss nach jedem Punkt ausgeführt werden)
    public void Startposition(){
        y= screensize.height/2;
        x= screensize.width/2- screensize.width/96;
    }

    public void changespeed(int ds){
        dx=dx+ds;
        dy=dx+ds;
    }
    public void changeballsize(int dc){
        width= screensize.width/32+dc;
        height= screensize.height/32+dc;
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
    public int getHeight(){
        return height;
    }
    public int getDx(){
        return dx;
    }
    public int getDy(){
        return dy;
    }

}
