package com.javapong;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
    Es wäre besser wenn Menu und Spiel zusammengeführt werden. Wir haben das versucht, hat aber nicht funktioniert.
    Es geht aber bestimmt irgendwie.
*/

public class Menu extends JFrame {

    private MenuBoardNeu menuBoard1;
    private float LautMinus = 20;
    private Timer timerSpielStart;
    private Spiel spiel1;
    private Color farbe_links = Color.white;        //Farbe der Paddles
    private Color farbe_rechts = Color.blue;
    private Color farbe_Ball= Color.white;
    private int delayBspeed = 6000;     //Schneller werden des Balls in ms

    public Menu() throws Exception {
        startMenu();                                    //Menu starten
        timerSpielStart = new Timer(64, actionListener1);      //Timer der alle (delay) Feuert
        timerSpielStart.start();                                    //für Abfragen aus dem Menu
    }

    public void startMenu() throws Exception {
        menuBoard1= new MenuBoardNeu(LautMinus);        //Menu starten
        add(menuBoard1);
        setTitle("Java-Pong-Menu");
        setSize(700,500);
        setUndecorated(false);
        setVisible(true);
        setLocationRelativeTo(null);                        //in die Mitte
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);                             //darf die Fenstergröße verändert werden? -> Nein
    }

    ActionListener actionListener1= new ActionListener() {      //Diese Methode wird vom Timer ausgeführt
        @Override                                               //Wir schauen ob sich was im Menu tut
        public void actionPerformed(ActionEvent e) {            //Modus wechselt -> aktion
            int modus = menuBoard1.getModus();


            if(modus==1||modus==2||modus==3||modus==4){ //Bei diesen Modi wird ein Spiel gestartet
                menuBoard1.setModus(0);                 //Modus wieder auf 0 setzen, sonst öffnet sich Pong dauerhaft
                menuBoard1.Menusoundstoppen();          // Musik stoppen, sonst Überlagerung
                try {
                    spiel1= new Spiel(farbe_rechts,farbe_links,farbe_Ball,LautMinus,modus,delayBspeed); //Modus wird übergeben
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

            if(modus==6){                               //6=Exit
                dispose();
                System.exit(0);                 //Programm beenden
            }
            if(spiel1!=null) {              //Wenn das Spiel geschlossen wird, kommt das Menu wieder
                if (spiel1.getSpielstopp() == true) {
                    try {
                        menuBoard1.Menusoundstarten();      //Sound wird wieder gestartete
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                spiel1=null;                //altes Spiel =null
                }
            }
        }
    };
}
