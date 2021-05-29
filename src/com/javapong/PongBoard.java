package com.javapong;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

public class PongBoard extends JPanel implements Runnable, ActionListener{           //Bord des Pong-Spiel
//Objekte deklarieren
private Paddle_links paddle_links;
private Paddle_rechts paddle_rechts;
private Ball ball1;
private Spielfeld spielfeld1;
private int delay=16;
private Timer timer;
private Color farbe_links;
private Color farbe_rechts;
private Color farbe_Ball;
private Thread ballthread;

public PongBoard(Color farbe_rechts,Color farbe_links, Color farbe_Ball){
    addKeyListener(new PongBoard.TAdapter());       //Initialisiert Key listener
    setBackground(Color.black);
    setFocusable(true);
    paddle_links=new Paddle_links();        //Initialisiert  Paddels
    paddle_rechts=new Paddle_rechts();
    ball1=new Ball();
    spielfeld1= new Spielfeld();
    this.farbe_links = farbe_links;     //Farben übernehmen
    this.farbe_rechts = farbe_rechts;
    this.farbe_Ball= farbe_Ball;
    timer = new Timer(delay, this);     //Irgendwas braucht das hier (die Bewegungsanimation der Paddles)
    timer.start();
    }

    @Override
    public void paintComponent(Graphics g){        //Eigentliche Zeichenklasse
    super.paintComponent(g);
    Graphics2D g2d= (Graphics2D) g; //Grafikobjekt in 2D-Grafikobjekt umwandeln
    paintPaddle_links(g2d);         //Paddles zeichnen
    paintPaddle_rechts(g2d);
    paintRahmen(g2d);
    paintBall(g2d);
    Toolkit.getDefaultToolkit().sync(); //Ruckelverbesserung, keine Ahnung wie
    }
    public void paintPaddle_rechts(Graphics2D g2d){
    g2d.setColor(farbe_rechts);
    g2d.fill3DRect(paddle_rechts.getX(), paddle_rechts.getY(), paddle_rechts.getWidth(), paddle_rechts.getHeight(),true);
    }
    public void paintPaddle_links(Graphics2D g2d){
    g2d.setColor(farbe_links);
    g2d.fill3DRect(paddle_links.getX(), paddle_links.getY(), paddle_links.getWidth(), paddle_links.getHeight(), true);
    }
    public void paintBall(Graphics2D g2d){
    g2d.setColor(farbe_Ball);
    g2d.fill3DRect(ball1.getX(), ball1.getY(), ball1.getWidth(), ball1.getHeight(), true);
    }
    public void paintRahmen(Graphics2D g2d){            //Rahmenkomponenten zeichnen
    g2d.setColor(Color.white);
    g2d.fill3DRect(spielfeld1.getXm(), spielfeld1.getYm(), spielfeld1.getMwidth(), spielfeld1.getMheight(), true);
    g2d.fill3DRect(spielfeld1.getXl(), spielfeld1.getYm(), spielfeld1.getMwidth(), spielfeld1.getMheight(), true);
    g2d.fill3DRect(spielfeld1.getXr(), spielfeld1.getYm(), spielfeld1.getMwidth(), spielfeld1.getMheight(), true);
    g2d.fill3DRect(0, spielfeld1.getYo(), spielfeld1.getSw(), spielfeld1.getMwidth(), true);
    g2d.fill3DRect(0, spielfeld1.getYu(), spielfeld1.getSw(), spielfeld1.getMwidth(), true);
    }
    @Override
    public void addNotify() {       //Der Thread für die Ball Animation wird hier gestartet
        super.addNotify();
        ballthread = new Thread(this);
        ballthread.start();
    }
    @Override
    public void run(){                      //Animation des Balles
        long beforeTime, timeDiff, sleep;
        beforeTime = System.currentTimeMillis();        //Timing für konstante Frames
        while(true) {                       //läuft für immer
            ball1.move();                   //verändern
            checkCollision();               //Collisions detection
            repaint(ball1.getX(), ball1.getY(), ball1.getWidth(), ball1.getHeight());
            timeDiff = System.currentTimeMillis() - beforeTime;     //mehr Timing
            sleep = 16 - timeDiff;                    //theoretisch 60 FPS
            if (sleep < 0) {
                sleep = 2;
            }
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {              //Error handling
                String msg = String.format("Thread interrupted: %s", e.getMessage());
                JOptionPane.showMessageDialog(this, msg, "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            beforeTime = System.currentTimeMillis();        //Timing reset
        }
    }
    public void checkCollision() {          //Collisions erkennen
        Rectangle rB = ball1.getBounds();
        Rectangle rPl= paddle_links.getBounds();
        Rectangle rPr= paddle_rechts.getBounds();
        Rectangle rBo=spielfeld1.getBoundsOben();
        Rectangle rBu=spielfeld1.getBoundsUnten();
        if(rB.intersects(rPl)||rB.intersects(rPr)) {    //Unterschiedlich für Rahmen und Paddles
            ball1.AbprallenPaddle();
        }
        if(rB.intersects(rBo)||rB.intersects(rBu)){
            ball1.AbprallenBoarder();
        }
    }
    public void actionPerformed(ActionEvent e) {        //wird nach Tastendruck ausgeführt
        paddle_rechts.move();
        paddle_links.move();
        int x = paddle_rechts.getX();
        int y = paddle_rechts.getY();
        //nur alles repainten funktioniert
        //repaint(paddle_rechts.getX(), paddle_rechts.getY(), paddle_rechts.getWidth(), paddle_rechts.getHeight());
        //repaint(paddle_links.getX(), paddle_links.getY(), paddle_links.getWidth(), paddle_links.getHeight());
        repaint();
    }
    private class TAdapter extends KeyAdapter {         //gibt Tastendrücke an Paddel weiter, keine Ahnung wie
        @Override
        public void keyReleased(KeyEvent e) {
            paddle_links.keyReleased(e);
            paddle_rechts.keyReleased(e);
        }
        @Override
        public void keyPressed(KeyEvent e) {
            paddle_links.keyPressed(e);
            paddle_rechts.keyPressed(e);
        }
    }
}