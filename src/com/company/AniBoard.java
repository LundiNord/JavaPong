package com.company;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AniBoard extends JPanel implements Runnable {
    private Image testImage;
    private int x, y;
    private Thread animator;

    public AniBoard() {
        startBord();
    }

    public void startBord() {           //Starten
        setBackground(Color.white);

        ImageIcon ii = new ImageIcon("src/resources/testBild.png");
        testImage = ii.getImage();

        x = -40;
        y = -40;

    }

    @Override
    public void addNotify() {
        super.addNotify();

        animator = new Thread(this);
        animator.start();

    }



     @Override
     public void paintComponent(Graphics g) {           //Zeichnen
         super.paintComponent(g);

         g.drawImage(testImage, x,y,null);

     }

     private void cycle() {
        x = x+1;
        y = y+1;

     }




    @Override
    public void run() {
    long beforeTime, timeDiff, sleep;

    beforeTime = System.currentTimeMillis();

    while(true) {

        cycle();
        repaint();
        timeDiff = System.currentTimeMillis() - beforeTime;
        sleep = 16 - timeDiff;
        if (sleep < 0) {
            sleep = 2;
        }

        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {

            String msg = String.format("Thread interrupted: %s", e.getMessage());

            JOptionPane.showMessageDialog(this, msg, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        beforeTime = System.currentTimeMillis();


    }

    }

}