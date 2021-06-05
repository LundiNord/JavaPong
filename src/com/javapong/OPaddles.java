package com.javapong;
import java.awt.*;
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
