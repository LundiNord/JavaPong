package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PongBoard extends JPanel implements ActionListener {           //Bord des Pong-Spiel
private Paddle_links paddle_links;
private Paddle_rechts paddle_rechts;
private Ball ball1;
private int delay=16;

public PongBoard(){


}






  //ActionListener funktionsfähig machen
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {

        }
        @Override
        public void keyPressed(KeyEvent e) {

        }

    }
}
