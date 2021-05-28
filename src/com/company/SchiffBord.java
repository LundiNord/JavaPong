package com.company;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SchiffBord extends JPanel implements ActionListener {

    private Timer timer;
    private TestSchiff testschiff1;
    private TestSchiff testschiff2;
    private int DELAY = 10;

    public SchiffBord() {
        startBord();
    }

    public void startBord() {
        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        testschiff1 = new TestSchiff();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }

    public void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(testschiff1.getImage(), testschiff1.getX(), testschiff1.getY(), null);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        testschiff1.move();
        repaint();


    }







    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            testschiff1.keyReleased(e);
        }
        @Override
        public void keyPressed(KeyEvent e) {
            testschiff1.keyPressed(e);
        }

    }
}