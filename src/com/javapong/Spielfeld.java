package com.javapong;

import java.awt.*;

public class Spielfeld {            //Mittellinie und Umrandungen
    //Variablen für die Mittellinie
    private int xm;
    private int ym;
    private int mwidth;
    private int mheight;
    private int xr,xl,yu,yo;
    private int sh; //screensize.height
    private int sw; //screensize.width

    //Kann Bildschirmgröße lesen
    Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public Spielfeld(){
        sw= screensize.width;
        sh= screensize.height;
        mheight=sh;
        mwidth= sw/256;
        xm= sw/2- sw/512;
        ym=0;
        xl=0;
        xr= sw-mwidth;
        yo=0;
        yu= sh-mwidth;
    }

    public int getXr(){
        return xr;
    }
    public int getXl(){
        return xl;
    }
    public int getXm(){
        return xm;
    }
    public int getYm(){
        return ym;
    }
    public int getMwidth(){
        return mwidth;
    }
    public int getMheight(){
        return mheight;
    }
    public int getYu(){
        return yu;
    }
    public int getYo(){
        return yo;
    }
    public int getSw(){
        return sw;
    }
    // Neues Rectangel erzeugen für CollisionDetection
    public Rectangle getBoundsOben(){
        return new Rectangle(0,yo,sw,mwidth);
    }
    // Neues Rectangel erzeugen für CollisionDetection
    public Rectangle getBoundsUnten(){
        return new Rectangle(0,yu,sw,mwidth);
    }
}