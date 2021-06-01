package com.javapong;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class Menu extends JFrame {

    private MenuBoardNeu menuBoard1;
    private float LautMinus;
    private Timer timerSpielStart;
    private Spiel spiel1;
    public Menu() throws Exception {
        startMenu();
        timerSpielStart = new Timer(64, actionListener1);      //Timer der alle (delay) Feuert
        timerSpielStart.start();
    }

    public void startMenu() throws Exception {
        menuBoard1= new MenuBoardNeu();
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
        @Override
        public void actionPerformed(ActionEvent e) {            //Wenn der Modus wechselt
            int modus = menuBoard1.getModus();

            if(modus==4){
                menuBoard1.setModus(0);                 //Modus wieder auf 0 setzen, sonst öffnet sich Pong dauerhaft
                menuBoard1.Menusoundstoppen();          // Musik stoppen, sonst Überlagerung
                try {
                    spiel1= new Spiel();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }

            if(modus==6){
                dispose();
                System.exit(0);                 //Programm beenden
            }
            if(spiel1!=null) {
                if (spiel1.getSpielstopp() == true) {
                    try {
                        menuBoard1.Menusoundstarten();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                spiel1=null;
                }
            }
        }
    };
}
