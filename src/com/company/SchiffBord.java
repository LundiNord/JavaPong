package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SchiffBord extends JPanel implements ActionListener {

    private Timer timer;
    private TestSchiff testschiff1;
    private Testschiff2 testschiff2;
    private int DELAY = 10;

    public SchiffBord() {
        startBord();
    }

    public void startBord() {
        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        testschiff1 = new TestSchiff();
        testschiff2= new Testschiff2();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
    }

    public void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(testschiff1.getImage(), testschiff1.getX(), testschiff1.getY(), null);
        g2d.drawImage(testschiff2.getImage(), testschiff2.getX(), testschiff2.getY(), null);
        if(checkCollision()==true) {
            g2d.drawString("Kaboom!",100,100);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        testschiff1.move();
        testschiff2.move();
        repaint();


    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            testschiff1.keyReleased(e);
            testschiff2.keyReleased(e);
        }
        @Override
        public void keyPressed(KeyEvent e) {
            testschiff1.keyPressed(e);
            testschiff2.keyPressed(e);
        }

    }
    public boolean checkCollision() {
        boolean x = false;

        Rectangle r1 = testschiff1.getBounds();
        Rectangle r2 = testschiff2.getBounds();

        if(r1.intersects(r2)) {
            x = true;
        }


        return x;
    }


}