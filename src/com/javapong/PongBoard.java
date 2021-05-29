package com.javapong;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PongBoard extends JPanel implements ActionListener {           //Bord des Pong-Spiel
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

public PongBoard(Color farbe_rechts,Color farbe_links, Color farbe_Ball){
    addKeyListener(new PongBoard.TAdapter());       //Initialisiert Key listener
    setBackground(Color.black);
    setFocusable(true);
    paddle_links=new Paddle_links();
    paddle_rechts=new Paddle_rechts();
    ball1=new Ball();
    spielfeld1= new Spielfeld();
    this.farbe_links = farbe_links;     //Farben übernehmen
    this.farbe_rechts = farbe_rechts;
    this.farbe_Ball= farbe_Ball;
    timer = new Timer(delay, this);     //Irgendwas braucht das hier
    timer.start();
}

    //Paddles zeichnen
    @Override
    public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2d= (Graphics2D) g; //Grafikobjekt in 2D-Grafikobjekt umwandeln
    paintPaddle_links(g2d);
    paintPaddle_rechts(g2d);
    paintRahmen(g2d);
    paintBall(g2d);

    Toolkit.getDefaultToolkit().sync(); //Ruckelverbesserung
    }

    public void paintPaddle_rechts(Graphics2D g2d){
    g2d.setColor(farbe_rechts);
    g2d.fill3DRect(paddle_rechts.getX(), paddle_rechts.getY(), paddle_rechts.getWidth(), paddle_rechts.getHeigth(),true);

    }

    public void paintPaddle_links(Graphics2D g2d){
    g2d.setColor(farbe_links);
    g2d.fill3DRect(paddle_links.getX(), paddle_links.getY(), paddle_links.getWidth(), paddle_links.getHeigth(), true);

    }

    public void paintBall(Graphics2D g2d){
    g2d.setColor(farbe_Ball);
    g2d.fill3DRect(ball1.getX(), ball1.getY(), ball1.getWidth(), ball1.getHeigth(), true);

    }

    public void paintRahmen(Graphics2D g2d){
    g2d.setColor(Color.white);
    g2d.fill3DRect(spielfeld1.getXm(), spielfeld1.getYm(), spielfeld1.getMwidth(), spielfeld1.getMheight(), true);
    g2d.fill3DRect(spielfeld1.getXl(), spielfeld1.getYm(), spielfeld1.getMwidth(), spielfeld1.getMheight(), true);
    g2d.fill3DRect(spielfeld1.getXr(), spielfeld1.getYm(), spielfeld1.getMwidth(), spielfeld1.getMheight(), true);
}



  //ActionListener funktionsfähig machen
    public void actionPerformed(ActionEvent e) {
        paddle_rechts.move();
        paddle_links.move();
        repaint();
        //repaint(paddle_links.getX(), paddle_links.getY(), paddle_links.getWidth(), paddle_links.getHeigth());
    }
    private class TAdapter extends KeyAdapter {
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
