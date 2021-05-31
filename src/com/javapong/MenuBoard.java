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
    private JButton Startbutton;
    private boolean menu2;

    //Kann Bildschirmgröße lesen
    Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public MenuBoard() throws IOException, FontFormatException  {
        startFont();
        Startbutton();
        addKeyListener(new MenuBoard.BAdapter());       //Initialisiert Key listener
        setBackground(Color.black);
        setFocusable(true);

    }
    @Override
    public void paintComponent(Graphics g) {        //Eigentliche Zeichenklasse
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g; //Grafikobjekt in 2D-Grafikobjekt umwandeln
        paintTitle(g2d);
        paintSubtitle(g2d);
        if(menu2==false) {
            paintStartbutton();
        }
    }

    public void paintTitle(Graphics2D g2d){
        g2d.setColor(Color.white);
        g2d.setFont(retroFont);
        g2d.drawString("Java-Pong",30,75);
    }

    public void paintSubtitle(Graphics2D g2d){
        g2d.setColor(Color.white);
        Font kretrofont= retroFont.deriveFont(Font.PLAIN,20);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(kretrofont);
        g2d.setFont(kretrofont);
        g2d.drawString("by Ricardo, Léon und Jan",100,100);
    }

    public void paintStartbutton(){
        Startbutton.setVisible(true);
        Startbutton.setText("Start");
        Startbutton.setSize(100,50);
        Startbutton.setLocation(200,200);
        Startbutton.setOpaque(false);
        Startbutton.setContentAreaFilled(false);
        Startbutton.setBorderPainted(false);
        add(Startbutton);

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

    public void Startbutton() {
            Startbutton= new JButton();
            Startbutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Start");
                }
            });



    }
}
