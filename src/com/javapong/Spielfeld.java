package com.javapong;

import java.awt.*;

public class Spielfeld {
    //Variablen für die Mittellinie
    private int xm;
    private int ym=0;//Muss zu Beginn 0 sein
    private int mwidth;
    private int mheight;

    public Spielfeld(){
        mheight=screensize.height/16;
        mwidth= screensize.width/32;
        xm= screensize.width/2- screensize.width/16;

    }

    public void hochzählen(){
      for (int i=0; i<= screensize.height/16;i++){

      }

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
    //Kann Bildschirmgröße lesen
    Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
}
