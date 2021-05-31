package com.javapong;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

public class MenuBoard extends JPanel implements ActionListener {
    private Font retroFont;
    //Kann Bildschirmgröße lesen
    Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public MenuBoard() throws IOException, FontFormatException  {
        startFont();
        addKeyListener(new PongBoard.BAdapter());       //Initialisiert Key listener
        setBackground(Color.black);
        setFocusable(true);
    }

    public void startFont() throws IOException, FontFormatException {       //Custom Font init
        File f = new File("src/resources/font/PressStart2P.ttf");       //Pfad zu .ttf File
        Font PressStart = Font.createFont(Font.TRUETYPE_FONT,f);                //Neue Font machen
        PressStart = PressStart.deriveFont(Font.PLAIN,70);                  //Größe, ... festlegen
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(PressStart);                                            //keine Ahnung
        retroFont = PressStart;                                                 //Abspeichern
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private class BAdapter extends KeyAdapter  {         //gibt Tastendrücke an Paddel weiter, keine Ahnung wie
        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();


        }

    }
}
