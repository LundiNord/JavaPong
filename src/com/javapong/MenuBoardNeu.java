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
    private JButton ButtonLeicht;
    private JButton ButtonMittel;
    private JButton ButtonSchwer;
    private JButton ButtonZurueck;
    private boolean menu2;
    private Sound menusound;
    private int modus=0;


    //Kann Bildschirmgröße lesen
    Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    /*  Hier gibt es bei den Buttons viel Code der Mehrfach vorkommt und unnötig ist. Wir haben es anders versucht,
        hat aber nicht funktioniert weil Buttons Arschlöcher sind. Deswegen jetzt so.
     */

    public MenuBoardNeu() throws Exception {            //Konstruktor
        startFont();
        Startbutton();              //button Init
        Startbutton2();
        Startbutton2online();
        Exitbutton();
        ButtonLeicht();
        ButtonMittel();
        ButtonSchwer();
        ButtonZurueck();
        //addKeyListener(new MenuBoardNeu.BAdapter());       //Initialisiert Key listener
        setBackground(Color.black);
        setFocusable(true);
        Menusoundstarten();
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
        else if(menu2==true) {
            paintModusLeicht();
            paintModusMittel();
            paintModusSchwer();
            paintZurück();
            paintButton2(g2d);
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
    public void paintSubtitle(Graphics2D g2d){      //selbsterklärend
        g2d.setColor(Color.white);
        g2d.setFont(retroFont);
        g2d.drawString("by Ricardo, Léon und Jan",100,100);
    }
    public void paintButton(Graphics2D g2d){        //Buttontext
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
    public void paintModusLeicht(){
        ButtonLeicht.setVisible(true);
        //Startbutton.setText("Start");
        ButtonLeicht.setSize(160,60);
        ButtonLeicht.setLocation(260,150);
        ButtonLeicht.setOpaque(false);
        ButtonLeicht.setContentAreaFilled(false);
        ButtonLeicht.setBorderPainted(false);
        add(ButtonLeicht);
    }
    public void paintModusMittel(){
        ButtonMittel.setVisible(true);
        //Startbutton2.setText("Start2");
        ButtonMittel.setSize(160,60);
        ButtonMittel.setLocation(260,225);
        ButtonMittel.setOpaque(false);
        ButtonMittel.setContentAreaFilled(false);
        ButtonMittel.setBorderPainted(false);
        add(ButtonMittel);
    }
    public void paintModusSchwer(){
        ButtonSchwer.setVisible(true);
        //Startbutton2online.setText("Start2o");
        ButtonSchwer.setSize(160,60);
        ButtonSchwer.setLocation(260,300);
        ButtonSchwer.setOpaque(false);
        ButtonSchwer.setContentAreaFilled(false);
        ButtonSchwer.setBorderPainted(false);
        add(ButtonSchwer);
    }
    public void paintZurück(){
        ButtonZurueck.setVisible(true);
        //ExitButton.setText("Exit");
        ButtonZurueck.setSize(130,60);
        ButtonZurueck.setLocation(275,375);
        ButtonZurueck.setOpaque(false);
        ButtonZurueck.setContentAreaFilled(false);
        ButtonZurueck.setBorderPainted(false);
        add(ButtonZurueck);
    }
    public void paintButton2(Graphics2D g2d){       //Buttontext 2
        g2d.setColor(Color.white);
        Font kretrofont= retroFont.deriveFont(Font.PLAIN,15);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(kretrofont);
        g2d.setFont(kretrofont);
        g2d.drawString("Leicht",295,190);
        g2d.drawString("Mittel",295,265);
        g2d.drawString("Schwer",295,340);
        g2d.drawString("Zurück",295,415);
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
    public void actionPerformed(ActionEvent e) {        //Ausgeführt wenn eine Taste gedrückt wird

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
                menu2=true;
                Startbutton.setVisible(false);
                Startbutton2.setVisible(false);
                Startbutton2online.setVisible(false);
                ExitButton.setVisible(false);
                repaint();
            }
        });
    }
    public void Startbutton2() {
        Startbutton2= new JButton();
        Startbutton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modus=4;
            }
        });
    }
    public void Startbutton2online() {
        Startbutton2online= new JButton();
        Startbutton2online.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modus=5;
            }
        });
    }
    public void Exitbutton() {
        ExitButton= new JButton();
        ExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modus=6;

            }
        });
    }

    public void ButtonLeicht() {
        ButtonLeicht= new JButton();
        ButtonLeicht.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modus=1;
            }
        });
    }
    public void ButtonMittel() {
        ButtonMittel= new JButton();
        ButtonMittel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modus=2;
            }
        });
    }
    public void ButtonSchwer() {
        ButtonSchwer= new JButton();
        ButtonSchwer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modus=3;
            }
        });
    }
    public void ButtonZurueck() {
        ButtonZurueck= new JButton();
        ButtonZurueck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu2=false;
                ButtonLeicht.setVisible(false);
                ButtonMittel.setVisible(false);
                ButtonSchwer.setVisible(false);
                ButtonZurueck.setVisible(false);
                repaint();
            }
        });
    }

    public void Menusoundstarten() throws Exception {
        menusound = new Sound("src/resources/sound/198896__bone666138__8-bit-circus-music.wav",20,true);
        menusound.playSound1();
    }
    public void Menusoundstoppen(){
        menusound.stopSound1();
    }
    public int getModus() {
        return modus;
    }
    public void setModus(int modus){
        this.modus=modus;
    }
}
