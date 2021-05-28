package com.company;

import javax.swing.JPanel;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class Board extends JPanel {

    public Board() {
        paintComponent();

    }

    @Override   //Ankündigung der Ändern einer Methode der Überklasse
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawDonut(g);
    }

    public void drawDonut(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh           //Macht die Objekte schöner
                = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);  //Macht die Objekte schöner

        Dimension size = getSize();     //Höhe/Breite des Fensters
        double w = size.getWidth();
        double h = size.getHeight();

        Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130);      //Zeichnen
        g2d.setStroke(new BasicStroke(20));
        g2d.setColor(Color.gray);

    }
}
