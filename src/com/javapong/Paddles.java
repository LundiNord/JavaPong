package com.javapong;

import java.awt.*;

public abstract class Paddles {
    //benötigte Variablen deklarieren
    private int height;
    private int width;
    //Kann Bildschirmgröße lesen
    Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public Paddles(){       //an Bildschirm angepasste größe
        height = screensize.height/8;
        width= screensize.width/64;
    }
    public void changeHeigth(int dheigth){
        height = height +dheigth;
    }
    public int getHeight(){
        return height;
    }
    public int getWidth(){
        return width;
    }
}