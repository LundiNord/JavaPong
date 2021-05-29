package com.company;

import java.awt.event.KeyEvent;

//Rechtes Paddle
public class Paddle_rechts extends Paddles {

    private int x;
    private int y;
    private int dy;
    private int heigth;
    private int width;

    public Paddle_rechts(){
        x=screensize.width/16+ screensize.width/16*14;
        y= screensize.height/2;
        heigth = super.heigth;
        width = super.width;
    }
    public void move(){
        y+=dy; //= x=x+dx;
    }

    //Eingabe erkennen
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            dy = -2;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
        }
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }

}
