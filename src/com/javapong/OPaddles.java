package com.javapong;
import java.awt.*;

/*
    Paddle für das Online Spiel, wir wissen noch nicht ob wir diese Klasse und die Unterklassen brauchen
*/

public abstract class OPaddles {
    private int height;
    private int width;

    public OPaddles(){
        height=125;                 //Fenstergröße 1500x1000 Pixel
        width=24;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
