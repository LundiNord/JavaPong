package com.company;

import java.awt.*;

public abstract class Paddles {
    //benötigte Variablen deklarieren
    protected int x;
    protected int y;
    private int dx;
    private int heigth;
    private int width;

    //Kann Bildschirmgröße lesen
    Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    public Paddles(){
        heigth= screensize.height/8;
        width= screensize.width/64;
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

}
