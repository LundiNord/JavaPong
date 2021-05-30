package com.javapong;
import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Spiel extends JFrame {         //Spiel Klasse es Pong-Spiels

    private Color farbe_links = Color.white;        //Farbe der Paddles
    private Color farbe_rechts = Color.blue;
    private Color farbe_Ball= Color.white;          //Farbe des Balls
    private Object Dimension;

    public Spiel() throws IOException, FontFormatException {
        startUI();
    }
    public void startUI() throws IOException, FontFormatException {
        add(new PongBoard(farbe_rechts, farbe_links, farbe_Ball));
        setTitle("Java-Pong Spiel");
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();    //Fenster an Bildschirm anpassen
        //setSize(screensize.width, screensize.height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        setLocationRelativeTo(null);                        //in die Mitte
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);                             //darf die Fenstergröße verändert werden? -> Nein
        //setMinimumSize(new Dimension(200,200));       //Fixme : funktioniert nicht
    }



}