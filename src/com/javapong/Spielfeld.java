package com.javapong;

import java.awt.*;

public class Spielfeld {
    //Variablen für die Mittellinie
    private int xm;
    private int ym;
    private int mwidth;
    private int mheight;
    private int xr,xl;

    //Kann Bildschirmgröße lesen
    Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public Spielfeld(){
        mheight=screensize.height;
        mwidth= screensize.width/256;
        xm= screensize.width/2- screensize.width/512;
        ym=0;
        xl=0;
        xr= screensize.width-mwidth;
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
}
