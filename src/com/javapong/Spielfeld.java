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
    private int xAl, xAr, yA;     //Anzeigen für die Koordinaten

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
        xAl= sw/4;
        xAr= sw/4 *3;
        yA = sh/12;
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
    public int getxAl() {
        return xAl;
    }
    public int getxAr() {
        return xAr;
    }
    public int getyA() {
        return yA;
    }
    public Rectangle getBoundsOben(){              // Neues Rectangel erzeugen für CollisionDetection
        return new Rectangle(0,yo,sw,mwidth);
    }
    public Rectangle getBoundsUnten(){             // Neues Rectangle erzeugen für CollisionDetection
        return new Rectangle(0,yu,sw,mwidth);
    }
    public Rectangle getBoundsLinks(){             // Neues Rectangle erzeugen für CollisionDetection
        return new Rectangle(xl,ym,mwidth,mheight);

    }public Rectangle getBoundsRechts(){           // Neues Rectangle erzeugen für CollisionDetection
        return new Rectangle(xr,yu,mwidth,mheight);
    }
}