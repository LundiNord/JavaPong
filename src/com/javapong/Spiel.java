package com.javapong;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Spiel extends JFrame {         //Spiel Klasse es Pong-Spiels

    private Color farbe_links = Color.white;        //Farbe der Paddles
    private Color farbe_rechts = Color.blue;
    private Color farbe_Ball= Color.white;          //Farbe des Balls
    private Object Dimension;
    private Timer timerClose;
    private PongBoard pongBoard1;
    private Sound Menusound;
    private float LautMinus=20;

    public Spiel() throws Exception {
        startUI();
        timerClose = new Timer(64, actionListener1);      //Timer der alle (delay) Feuert
        timerClose.start();
    }
    public void startUI() throws Exception {
        pongBoard1 = new PongBoard(farbe_rechts,farbe_links,farbe_Ball,LautMinus);
        add(pongBoard1);
        //add(new PongBoard(farbe_rechts, farbe_links, farbe_Ball));
        setTitle("Java-Pong Spiel");
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();    //Fenster an Bildschirm anpassen
        //setSize(screensize.width, screensize.height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        setLocationRelativeTo(null);                        //in die Mitte
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);                             //darf die Fenstergröße verändert werden? -> Nein

    }


    public void Menusoundstarten() throws Exception {
        Menusound= new Sound("src/resources/sound/198896__bone666138__8-bit-circus-music.wav",20,true);
        Menusound.playSound1();
    }

    ActionListener actionListener1= new ActionListener() {      //Diese Methode wird vom Timer ausgeführt
        @Override
        public void actionPerformed(ActionEvent e) {            //Wenn ESC gedrückt wird, wir geschlossen
            if(pongBoard1.getClose()==true) {
                dispose();
            }
        }
    };
}