package com.company;

import java.awt.event.KeyEvent;

//Linkes Paddle
public class Paddle_links extends Paddles {

    private int x;
    private int y;
    private int dy;
    private int heigth;
    private int width;

    public Paddle_links(){
    x=screensize.width/16;
    y=screensize.height/2;
    heigth = super.heigth;
    width= super.width;
    }
    public void move(){
        y+=dy; //= y=y+dy;
    }

    //Eingabe erkennen
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            dy = -2;
        }

        if (key == KeyEvent.VK_S) {
            dy = 2;
        }
    }
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            dy = 0;
        }

        if (key == KeyEvent.VK_S) {
            dy = 0;
        }
    }
}
