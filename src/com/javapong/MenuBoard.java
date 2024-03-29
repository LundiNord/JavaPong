package com.javapong;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

/*
        --Funktioniert nicht -> MenuBoardNeu
*/

public class MenuBoard extends JPanel implements ActionListener {

    private Font retroFont;
    private JButton startbutton1;
    private JButton startbutton2;
    private JButton startbutton2online;
    private JButton exitbutton;
    private boolean menu2 = false;
    private Sound menusound;
    private int x = 0;
    private JButton Startbutton;

    //Kann Bildschirmgröße lesen
    Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public MenuBoard() throws Exception {
        startFont();
        addKeyListener(new MenuBoard.BAdapter());       //Initialisiert Key listener
        setBackground(Color.black);
        setFocusable(true);
        Menusoundstarten();
        InitStartbutton1();
        InitStartButton2();
        InitStartbutton2online();
        InitExitButton();
        System.out.print("test");

    }
    public void paintStartbutton() {
        Startbutton.setVisible(true);
        Startbutton.setText("Start");
        Startbutton.setSize(100,50);
        Startbutton.setLocation(200,200);
        Startbutton.setOpaque(false);
        Startbutton.setContentAreaFilled(false);
        Startbutton.setBorderPainted(false);
        add(Startbutton);

    }

    @Override
    public void paintComponent(Graphics g) {        //Eigentliche Zeichenklasse
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g; //Grafikobjekt in 2D-Grafikobjekt umwandeln
        paintTitle(g2d);
        paintSubtitle(g2d);
        paintStartbutton();
        //if(menu2==false) {
            //paintExitButton();
           // paintStartbutton2online();
            //InitStartbutton2online();
        //}

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

    public void InitStartbutton1() {
        startbutton1 = new JButton();
        startbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Start");

            }
        });
        startbutton1.setText("Start");
        startbutton1.setSize(100,50);
        startbutton1.setLocation(200,200);
        startbutton1= initButton(startbutton1);
    }
    public void paintStartbutton1(){        //Einzelspieler Start
        //add(startbutton1);
    }
    public void InitStartButton2() {
        startbutton2 = new JButton();
        startbutton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Start");

            }
        });
        startbutton2.setText("Start2");
        startbutton2.setSize(100,50);
        startbutton2.setLocation(300,200);
        startbutton2= initButton(startbutton2);
    }
    public void paintStartbutton2() {           //lokaler Multiplayer Button
        //add(startbutton2);

    }
    public void InitStartbutton2online() {
        startbutton2online = new JButton();
        startbutton2online.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Start");

            }
        });
        startbutton2online.setText("Startonline");
        startbutton2online.setSize(100,50);
        startbutton2online.setLocation(400,300);
        startbutton2online.setVisible(true);
        startbutton2online.setOpaque(false);
        startbutton2online.setContentAreaFilled(false);
        startbutton2online.setBorderPainted(false);
        //add(startbutton2online);

    }
    public void paintStartbutton2online() {         //OnlineMultiplayer Button
        add(startbutton2online);
    }
    public void InitExitButton() {
        exitbutton = new JButton();
        exitbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Start");

            }
        });
        exitbutton.setText("Exit");
        exitbutton.setSize(100,50);
        exitbutton.setLocation(500,200);
        exitbutton = initButton(exitbutton);
    }
    public void paintExitButton() {
        add(exitbutton);
    }


    public JButton initButton(JButton button1) {        //Init Button
        button1.setVisible(true);
        button1.setOpaque(false);
        button1.setContentAreaFilled(false);
        button1.setBorderPainted(false);
        return button1;
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
    public void actionPerformed(ActionEvent m) {            //wenn Key gepressed wird

    }
    private class BAdapter extends KeyAdapter  {
        @Override
        public void keyReleased(KeyEvent m) {

        }

        @Override
        public void keyPressed(KeyEvent m) {
            int key = m.getKeyCode();

        }

    }

    public void Menusoundstarten() throws Exception {
        menusound = new Sound("src/resources/sound/198896__bone666138__8-bit-circus-music.wav",20,true);
        //menusound.playSound1();
    }
}
