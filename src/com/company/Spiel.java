package com.company;
import java.awt.*;
import javax.swing.*;

public class Spiel extends JFrame {

    public Spiel() {
        startUI();
    }
    public void startUI() {
        add(new PongBoard());
        setTitle("Moving sprite");
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screensize.width, screensize.height);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

}
