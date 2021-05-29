package com.company;

import jdk.jfr.Frequency;

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
private int delay=16;

public PongBoard(){
    setBackground(Color.black);
    setFocusable(true);
    paddle_links=new Paddle_links();
    paddle_rechts=new Paddle_rechts();
}
    //Paddles zeichnen
    @Override
    public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2d= (Graphics2D)g; //Grafikobjekt in 2D-Grafikobjekt umwandeln
    paintPaddle_links(g2d);
    paintPaddle_rechts(g2d);
    Toolkit.getDefaultToolkit().sync(); //Ruckelverbesserung
    }





    public void paintPaddle_rechts(Graphics2D g2d){
    g2d.setColor(Color.white);
    g2d.fill3DRect(paddle_rechts.getX(), paddle_rechts.getY(), paddle_rechts.getWidth(), paddle_rechts.getHeigth(),true);

    }

    public void paintPaddle_links(Graphics2D g2d){
    g2d.setColor(Color.white);
    g2d.fill3DRect(paddle_links.getX(), paddle_links.getY(), paddle_links.getWidth(), paddle_links.getHeigth(), true);

    }




  //ActionListener funktionsfähig machen
    public void actionPerformed(ActionEvent e) {
        paddle_rechts.move();
        paddle_links.move();
        repaint();
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
