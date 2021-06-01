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

    public Menu() throws Exception {
        startMenu();
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

}
