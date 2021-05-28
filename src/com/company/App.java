package com.company;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class App extends JFrame {

    public App() {

        startUI();
    }

    public void startUI() {
        add(new Board());

        setSize(1000, 600);
        setTitle("Test Appp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);    //öffnet sich in der Mitte des Bildschirmes
    }


}

