package com.javapong;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spiel extends JFrame {         //Spiel Klasse es Pong-Spiels

    private Color farbe_links = Color.white;        //Farbe der Paddles
    private Color farbe_rechts = Color.blue;
    private Color farbe_Ball= Color.white;          //Farbe des Balls
    private int modus;
    private Timer timerClose;
    private PongBoard pongBoard1;
    private float LautMinus;
    private Menu menu1;
    private int mode;               //Spielmodus
    private boolean spielstopp=false;
    private int delayBspeed;

    //Wird vom Menu ausgeführt und ruft das PongBoard auf

    public Spiel(Color farbe_rechts,Color farbe_links,Color farbe_Ball,float LautMinus, int modus,int delayBspeed) throws Exception {
        this.farbe_links = farbe_links;
        this.farbe_rechts = farbe_rechts;
        this.farbe_Ball = farbe_Ball;
        this.LautMinus = LautMinus;
        this.modus= modus;
        this.delayBspeed = delayBspeed;
        startGame();                        //Spielstart
        timerClose = new Timer(64, actionListener1);      //Timer der alle (delay) Feuert
        timerClose.start();
    }
    public void startGame() throws Exception {
        pongBoard1 = new PongBoard(farbe_rechts,farbe_links,farbe_Ball,LautMinus, modus,delayBspeed);
        add(pongBoard1);
        setTitle("Java-Pong-Spiel");
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();    //Fenster an Bildschirm anpassen
        //setSize(screensize.width, screensize.height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        setLocationRelativeTo(null);                        //in die Mitte
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);                             //darf die Fenstergröße verändert werden? -> Nein
    }

    ActionListener actionListener1= new ActionListener() {      //Diese Methode wird vom Timer ausgeführt
        @Override
        public void actionPerformed(ActionEvent e) {            //Wenn ESC gedrückt wird, wir geschlossen
            if(pongBoard1.getClose()==true) {
                dispose();
                pongBoard1.stop();
                spielstopp=true;
            }
        }
    };
    public boolean getSpielstopp(){
        return spielstopp;
    }
}