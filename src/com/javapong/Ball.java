package com.javapong;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

public class Ball  {

    private int x;
    private int y;
    //private int xo;         //x old
    //private int yo;         //y old
    private int dx;
    private int dy;
    private int width;
    private int height;
    private int defaultSpeed = 10;
    private int delayBspeed;
    private Timer timerBspeed;

    //Kann Bildschirmgröße lesen
    Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public Ball(int delayBspeed){
        width= screensize.width/48;
        height= width;
        Startposition();
        startBall();
        this.delayBspeed = delayBspeed;
        timerBspeed = new Timer(delayBspeed, actionListener1);      //Timer der alle (delay) Feuert
        timerBspeed.start();                                        //für den schneller werdenden Ball
    }

    ActionListener actionListener1= new ActionListener() {      //Diese Methode wird vom Timer ausgeführt
        @Override
        public void actionPerformed(ActionEvent e) {
            //defaultSpeed=defaultSpeed+2;
            if(dx<0) {              //Speed wird erhöht aber nur bis zum Ballreset
                dx = dx -2;
            }
            else {
                dx = dx+2;
            }
            if(dy<0) {
                dy = dy -2;
            }
            else {
                dy = dy+2;
            }
        }
    };
    public void Startposition(){        //Startposition festlegen
        y= screensize.height/2;
        x= screensize.width/2- screensize.width/96;
    }
    public void changeballsize(int dc){
        width= screensize.width/32+dc;
        height= screensize.height/32+dc;
    }
    public Rectangle getBounds(){           // Neues Rectangel erzeugen für CollisionDetection
        return new Rectangle(x,y,getWidth(),getHeight());
    }
    public void move(){
        x+=dx;
        y+=dy;
    }
    public void AbprallenPaddle(){
        dx=-dx;         //x dreht sich
        dy=dy;          //y nicht
    }
    public void AbprallenBoarder(){
        dx=dx;          //x dreht sich nicht
        dy=-dy;         //y schon
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getWidth(){
         return width;
    }
    public int getHeight(){
        return height;
    }
    public int getDx(){
        return dx;
    }
    public int getDy(){
        return dy;
    }
    public void startBall() {       //Ball fliegt zufällig los
        int d = new java.util.Random().nextInt(5);
        if(d==1) {
            dx = defaultSpeed;
            dy = defaultSpeed;
        }
        else if(d==2) {
            dx = -defaultSpeed;
            dy = -defaultSpeed;
        }
        else if(d==3) {
            dx = -defaultSpeed;
            dy = defaultSpeed;
        }
        else {
            dx = defaultSpeed;
            dy = -defaultSpeed;
        }
    }
    public void resetBall(boolean links) {          //Ball nach einem Tor auf den Mittelpunkt setzen
        int d = new java.util.Random().nextInt(3);
        if(links==true) {                   //fliegt nach links weg
            Startposition();
            wait(100);
            if(d==1) {
                dx = -defaultSpeed;
                dy = defaultSpeed;
            }
            else {
                dx = -defaultSpeed;
                dy = -defaultSpeed;
            }
        }
        else {                          //fliegt nach rechts weg
            Startposition();
            wait(100);
            if(d==1) {
                dx = defaultSpeed;
                dy = -defaultSpeed;
            }
            else {
                dx = defaultSpeed;
                dy = defaultSpeed;
            }
        }
    }
    public static void wait(int ms){
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

}