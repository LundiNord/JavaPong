package com.company;

import javax.swing.JPanel;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Board extends JPanel {



    public Board() {
        startBoard();

    }




    public void drawDonut(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);  //Macht die Objekte schöner

        Dimension size = getSize();     //Höhe/Breite des Fensters
        double w = size.getWidth();
        double h = size.getHeight();

              //Zeichnen
        g2d.setStroke(new BasicStroke(20));
        g2d.setColor(Color.gray);
        g2d.fill3DRect(0,0,20,20,true);
        String str = "Test";
        g2d.drawString(str,50,50);
    }



    private Image testBild;
    public void startBoard() {
        loadBild();

    }
    public void  loadBild() {
        ImageIcon ii = new ImageIcon("src/resources/testBild.png");
        testBild = ii.getImage();
    }


    @Override   //Ankündigung der Ändern einer Methode der Überklasse
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawDonut(g);
        g.drawImage(testBild, 0, 0, null);
    }
}
