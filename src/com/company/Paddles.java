package com.company;

import java.awt.*;

public abstract class Paddles {
    //benötigte Variablen deklarieren
    protected int x;
    protected int y;
    protected int dy;
    protected int heigth;
    protected int width;

    //Kann Bildschirmgröße lesen
    Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    public Paddles(){
        heigth= screensize.height/8;
        width= screensize.width/64;
    }

        public void move(){
        y+=dy; //= x=x+dx;
        }

    public int getX(){
         return x;
    }
    public int getY(){
         return y;
    }
    public int getHeigth(){
        return heigth;
    }
    public int getWidth(){
        return width;
    }
    // Neues Rectangel erzeugen für CollisionDetection
    public Rectangle getBounds(){
        return new Rectangle(x,y,width,heigth);
    }
}
