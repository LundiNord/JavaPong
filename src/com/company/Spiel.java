package com.company;
import java.awt.*;
import javax.swing.*;

public class Spiel extends JFrame {         //Spiel Klasse es Pong-Spiels

    public Spiel() {
        startUI();
    }
    public void startUI() {
        add(new PongBoard());
        setTitle("Java-Pong Spiel");
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();    //Fenster an Bildschirm anpassen
        setSize(screensize.width, screensize.height);
        setVisible(true);
        setLocationRelativeTo(null);            //in die Mitte
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);     //darf die Fenstergröße verändert werden?
    }

}
