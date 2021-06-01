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

public class MenuBoardNeu extends JPanel implements ActionListener {
    private Font retroFont;
    private JButton Startbutton;
    private JButton Startbutton2;
    private JButton Startbutton2online;
    private JButton ExitButton;
    private boolean menu2;

    //Kann Bildschirmgröße lesen
    Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public MenuBoardNeu() throws IOException, FontFormatException  {
        startFont();
        Startbutton();
        Startbutton2();
        Startbutton2online();
        Exitbutton();
        addKeyListener(new MenuBoardNeu.BAdapter());       //Initialisiert Key listener
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
            paintStartbutton2();
            paintStartbutton2online();
            paintExitbutton();
            paintButton(g2d);
        }
    }

    public void paintTitle(Graphics2D g2d){
        g2d.setColor(Color.white);
        Font kretrofont= retroFont.deriveFont(Font.PLAIN,70);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(kretrofont);
        g2d.setFont(kretrofont);
        g2d.drawString("Java-Pong",30,75);
    }

    public void paintSubtitle(Graphics2D g2d){
        g2d.setColor(Color.white);
        g2d.setFont(retroFont);
        g2d.drawString("by Ricardo, Léon und Jan",100,100);
    }

    public void paintButton(Graphics2D g2d){
        g2d.setColor(Color.white);
        Font kretrofont= retroFont.deriveFont(Font.PLAIN,15);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(kretrofont);
        g2d.setFont(kretrofont);
        g2d.drawString("Einzelspieler",250,190);
        g2d.drawString("Lokaler Mehrspieler",200,265);
        g2d.drawString("Online Modus",255,340);
        g2d.drawString("Beenden",290,415);
    }

    public void paintStartbutton(){
        Startbutton.setVisible(true);
        //Startbutton.setText("Start");
        Startbutton.setSize(205,60);
        Startbutton.setLocation(245,150);
        Startbutton.setOpaque(false);
        Startbutton.setContentAreaFilled(false);
        Startbutton.setBorderPainted(false);
        add(Startbutton);
    }
    public void paintStartbutton2(){
        Startbutton2.setVisible(true);
        //Startbutton2.setText("Start2");
        Startbutton2.setSize(300,60);
        Startbutton2.setLocation(195,225);
        Startbutton2.setOpaque(false);
        Startbutton2.setContentAreaFilled(false);
        Startbutton2.setBorderPainted(false);
        add(Startbutton2);
    }
    public void paintStartbutton2online(){
        Startbutton2online.setVisible(true);
        //Startbutton2online.setText("Start2o");
        Startbutton2online.setSize(190,60);
        Startbutton2online.setLocation(250,300);
        Startbutton2online.setOpaque(false);
        Startbutton2online.setContentAreaFilled(false);
        Startbutton2online.setBorderPainted(false);
        add(Startbutton2online);
    }
    public void paintExitbutton(){
        ExitButton.setVisible(true);
        //ExitButton.setText("Exit");
        ExitButton.setSize(130,60);
        ExitButton.setLocation(275,375);
        ExitButton.setOpaque(false);
        ExitButton.setContentAreaFilled(false);
        ExitButton.setBorderPainted(false);
        add(ExitButton);
    }
    public void startFont() throws IOException, FontFormatException {       //Custom Font init
        File f = new File("src/resources/font/PressStart2P.ttf");       //Pfad zu .ttf File
        Font PressStart = Font.createFont(Font.TRUETYPE_FONT,f);                //Neue Font machen
        PressStart = PressStart.deriveFont(Font.PLAIN,20);                  //Größe, ... festlegen
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
    public void Startbutton2() {
        Startbutton2= new JButton();
        Startbutton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Start");
            }
        });
    }
    public void Startbutton2online() {
        Startbutton2online= new JButton();
        Startbutton2online.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Start");
            }
        });
    }
    public void Exitbutton() {
        ExitButton= new JButton();
        ExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Start");
            }
        });
    }
}
