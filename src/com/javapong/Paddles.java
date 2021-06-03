package com.javapong;

import java.awt.*;

public abstract class Paddles {
    //benötigte Variablen deklarieren
    private int height;
    private int width;
    private int height1;
    private int height2;
    private int height3;
    //Kann Bildschirmgröße lesen
    Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public Paddles(){       //an Bildschirm angepasste größe
        height = screensize.height/8;
        width= screensize.width/64;
        height1= screensize.height/128;
        height2= screensize.height/8/4;
        height3=screensize.height/8*3/8;
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
    public int getHeight1() {
        return height1;
    }
    public int getHeight2() {
        return height2;
    }
    public int getHeight3() {
        return height3;
    }
}