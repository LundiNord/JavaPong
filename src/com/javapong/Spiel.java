package com.javapong;
import java.awt.*;
import javax.swing.*;

public class Spiel extends JFrame {         //Spiel Klasse es Pong-Spiels

    private Color farbe_links = Color.white;        //Farbe der Paddles
    private Color farbe_rechts = Color.blue;
    private Object Dimension;

    public Spiel() {
        startUI();
    }
    public void startUI() {
        add(new PongBoard(farbe_rechts, farbe_links));
        setTitle("Java-Pong Spiel");
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();    //Fenster an Bildschirm anpassen
        setSize(screensize.width, screensize.height);
        setVisible(true);
        setLocationRelativeTo(null);            //in die Mitte
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);     //darf die Fenstergröße verändert werden?
        setMinimumSize(new Dimension(200,200)); //Fixme : funktioniert nicht
    }

}
