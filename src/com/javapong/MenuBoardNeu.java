package com.javapong;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

public class MenuBoardNeu extends JPanel {
    private Font retroFont;
    private JButton Startbutton;
    private JButton Startbutton2;
    private JButton Startbutton2online;
    private JButton ExitButton;
    private JButton ButtonLeicht;
    private JButton ButtonMittel;
    private JButton ButtonSchwer;
    private JButton ButtonZurueck;
    private JButton ButtonSettings;
    private JButton ButtonZurueck2;
    private JButton ButtonLLeise;
    private JButton ButtonLMittel;
    private JButton ButtonLLaut;
    private Image ButtonImage;
    private int menu = 1;
    private Sound menusound;
    private int modus = 0;
    private float LautMinus;

    /*  Hier gibt es bei den Buttons viel Code der mehrfach vorkommt und unnötig ist. Wir haben es anders versucht,
        hat aber nicht funktioniert weil Buttons Arschlöcher sind. Deswegen jetzt so.
        Hier wird das Menu gezeichnet
     */

    public MenuBoardNeu(float LautMinus) throws Exception {            //Konstruktor
        this.LautMinus = LautMinus;
        ImageIcon IS = new ImageIcon("resources/icons8-gears-50.png");
        ButtonImage = IS.getImage();
        startFont();
        Startbutton();              //button Init
        Startbutton2();
        Startbutton2online();
        Exitbutton();
        ButtonLeicht();
        ButtonMittel();
        ButtonSchwer();
        ButtonZurueck();
        ButtonSettings();
        ButtonZurueck2();
        ButtonLLeise();
        ButtonLMittel();
        ButtonLLaut();
        setBackground(Color.black);
        setFocusable(true);
        Menusoundstarten();
    }

    @Override                                           //Eigentliche Zeichenmethode
    public void paintComponent(Graphics g) {            //Überschriebene Methode aus dem JPanel
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;    //Grafikobjekt in 2D-Grafikobjekt umwandeln
        paintTitle(g2d);
        paintSubtitle(g2d);
        if (menu == 1) {        //Menu1
            paintStartbutton();
            paintStartbutton2();
            paintStartbutton2online();
            paintExitbutton();
            paintMenu1(g2d);
            paintSettingsbutton();
        } else if (menu == 2) {      //Menu2
            paintModusLeicht();
            paintModusMittel();
            paintModusSchwer();
            paintZurück();
            paintMenu2(g2d);
        } else if (menu == 3) {     //Menu 3 (Settings)
            paintZurück2();
            paintButtonLLeise();
            paintButtonLMittel();
            paintButtonLLaut();
            paintMenu3(g2d);
        }
    }

    //paint Methoden
    public void paintTitle(Graphics2D g2d) {
        g2d.setColor(Color.white);
        Font kretrofont = retroFont.deriveFont(Font.PLAIN, 70);       //Größe der Font aendern
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(kretrofont);
        g2d.setFont(kretrofont);
        g2d.drawString("Java-Pong", 30, 75);
    }
    public void paintSubtitle(Graphics2D g2d) {      //selbsterklärend
        g2d.setColor(Color.white);
        g2d.setFont(retroFont);
        g2d.drawString("by Ricardo, Léon und Jan", 100, 100);
    }
//Menu 1 + Buttons
    public void paintMenu1(Graphics2D g2d) {        //Buttontext
        g2d.setColor(Color.white);
        Font kretrofont = retroFont.deriveFont(Font.PLAIN, 15);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(kretrofont);
        g2d.setFont(kretrofont);
        g2d.drawString("Einzelspieler", 250, 190);
        g2d.drawString("Lokaler Mehrspieler", 200, 265);
        g2d.drawString("Online Modus", 255, 340);
        g2d.drawString("Beenden", 290, 415);
        g2d.drawImage(ButtonImage, 620, 400, null);
    }
    public void paintStartbutton() {        //eigentlich Selbsterklärend
        Startbutton.setVisible(true);
        Startbutton.setSize(205, 60);
        Startbutton.setLocation(245, 150);
        Startbutton.setOpaque(false);
        Startbutton.setContentAreaFilled(false);
        Startbutton.setBorderPainted(false);
        add(Startbutton);
    }
    public void paintStartbutton2() {
        Startbutton2.setVisible(true);
        //Startbutton2.setText("Start2");
        Startbutton2.setSize(300, 60);
        Startbutton2.setLocation(195, 225);
        Startbutton2.setOpaque(false);
        Startbutton2.setContentAreaFilled(false);
        Startbutton2.setBorderPainted(false);
        add(Startbutton2);
    }
    public void paintStartbutton2online() {
        Startbutton2online.setVisible(true);
        //Startbutton2online.setText("Start2o");
        Startbutton2online.setSize(190, 60);
        Startbutton2online.setLocation(250, 300);
        Startbutton2online.setOpaque(false);
        Startbutton2online.setContentAreaFilled(false);
        Startbutton2online.setBorderPainted(false);
        add(Startbutton2online);
    }
    public void paintExitbutton() {
        ExitButton.setVisible(true);
        //ExitButton.setText("Exit");
        ExitButton.setSize(130, 60);
        ExitButton.setLocation(275, 375);
        ExitButton.setOpaque(false);
        ExitButton.setContentAreaFilled(false);
        ExitButton.setBorderPainted(false);
        add(ExitButton);
    }
    public void paintSettingsbutton() {
        ButtonSettings.setVisible(true);
        //ExitButton.setText("Exit");
        ButtonSettings.setSize(50, 50);
        ButtonSettings.setLocation(620, 400);
        ButtonSettings.setOpaque(false);
        ButtonSettings.setContentAreaFilled(false);
        ButtonSettings.setBorderPainted(false);
        add(ButtonSettings);
    }
//Menu 2 + Buttons
    public void paintMenu2(Graphics2D g2d) {       //Buttontext 2
        g2d.setColor(Color.white);
        Font kretrofont = retroFont.deriveFont(Font.PLAIN, 15);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(kretrofont);
        g2d.setFont(kretrofont);
        g2d.drawString("Leicht", 295, 190);
        g2d.drawString("Mittel", 295, 265);
        g2d.drawString("Schwer", 295, 340);
        g2d.drawString("Zurück", 295, 415);
    }
    public void paintModusLeicht() {
        ButtonLeicht.setVisible(true);
        //Startbutton.setText("Start");
        ButtonLeicht.setSize(160, 60);
        ButtonLeicht.setLocation(260, 150);
        ButtonLeicht.setOpaque(false);
        ButtonLeicht.setContentAreaFilled(false);
        ButtonLeicht.setBorderPainted(false);
        add(ButtonLeicht);
    }
    public void paintModusMittel() {
        ButtonMittel.setVisible(true);
        //Startbutton2.setText("Start2");
        ButtonMittel.setSize(160, 60);
        ButtonMittel.setLocation(260, 225);
        ButtonMittel.setOpaque(false);
        ButtonMittel.setContentAreaFilled(false);
        ButtonMittel.setBorderPainted(false);
        add(ButtonMittel);
    }
    public void paintModusSchwer() {
        ButtonSchwer.setVisible(true);
        //Startbutton2online.setText("Start2o");
        ButtonSchwer.setSize(160, 60);
        ButtonSchwer.setLocation(260, 300);
        ButtonSchwer.setOpaque(false);
        ButtonSchwer.setContentAreaFilled(false);
        ButtonSchwer.setBorderPainted(false);
        add(ButtonSchwer);
    }
    public void paintZurück() {
        ButtonZurueck.setVisible(true);
        //ExitButton.setText("Exit");
        ButtonZurueck.setSize(130, 60);
        ButtonZurueck.setLocation(275, 375);
        ButtonZurueck.setOpaque(false);
        ButtonZurueck.setContentAreaFilled(false);
        ButtonZurueck.setBorderPainted(false);
        add(ButtonZurueck);
    }
//Menu 3 + Buttons
    public void paintMenu3(Graphics2D g2d) {       //Buttontext 2
        g2d.setColor(Color.white);
        Font kretrofont = retroFont.deriveFont(Font.PLAIN, 15);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(kretrofont);
        g2d.setFont(kretrofont);
        g2d.drawString("Leise", 155, 200);
        g2d.drawString("Mittel", 295, 200);
        g2d.drawString("Laut", 450, 200);
        g2d.drawString("Zurück", 295, 415);
    }
    public void paintButtonLLeise(){
        ButtonLLeise.setVisible(true);
        ButtonLLeise.setSize(100,30);
        ButtonLLeise.setLocation(145,175);
        ButtonLLeise.setOpaque(false);
        ButtonLLeise.setContentAreaFilled(false);
        ButtonLLeise.setBorderPainted(false);
        add(ButtonLLeise);
    }
    public void paintButtonLMittel(){
        ButtonLMittel.setVisible(true);
        ButtonLMittel.setSize(110,30);
        ButtonLMittel.setLocation(285,175);
        ButtonLMittel.setOpaque(false);
        ButtonLMittel.setContentAreaFilled(false);
        ButtonLMittel.setBorderPainted(false);
        add(ButtonLMittel);
    }
    public void paintButtonLLaut(){
        ButtonLLaut.setVisible(true);
        ButtonLLaut.setSize(80,30);
        ButtonLLaut.setLocation(440,175);
        ButtonLLaut.setOpaque(false);
        ButtonLLaut.setContentAreaFilled(false);
        ButtonLLaut.setBorderPainted(false);
        add(ButtonLLaut);
    }
    public void paintZurück2() {
        ButtonZurueck2.setVisible(true);
        ButtonZurueck2.setSize(130, 60);
        ButtonZurueck2.setLocation(275, 375);
        ButtonZurueck2.setOpaque(false);
        ButtonZurueck2.setContentAreaFilled(false);
        ButtonZurueck2.setBorderPainted(false);
        add(ButtonZurueck2);
    }

    //Button Init Menu1
    public void Startbutton() {
        Startbutton = new JButton();
        Startbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu = 2;
                Startbutton.setVisible(false);
                Startbutton2.setVisible(false);
                Startbutton2online.setVisible(false);
                ExitButton.setVisible(false);
                repaint();
            }
        });
    }
    public void Startbutton2() {
        Startbutton2 = new JButton();
        Startbutton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modus = 4;
            }
        });
    }
    public void Startbutton2online() {
        Startbutton2online = new JButton();
        Startbutton2online.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modus = 5;
                JOptionPane.showMessageDialog(null, "Feature coming soon!");
            }
        });
    }
    public void Exitbutton() {
        ExitButton = new JButton();
        ExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modus = 6;
            }
        });
    }
    public void ButtonSettings() {
        ButtonSettings = new JButton();
        ButtonSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu = 3;
                Startbutton.setVisible(false);
                Startbutton2.setVisible(false);
                Startbutton2online.setVisible(false);
                ExitButton.setVisible(false);
                repaint();
            }
        });
    }

    //Button Init Menu2
    public void ButtonLeicht() {
        ButtonLeicht = new JButton();
        ButtonLeicht.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modus = 1;
            }
        });
    }
    public void ButtonMittel() {
        ButtonMittel = new JButton();
        ButtonMittel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modus = 2;
            }
        });
    }
    public void ButtonSchwer() {
        ButtonSchwer = new JButton();
        ButtonSchwer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modus = 3;
            }
        });
    }
    public void ButtonZurueck() {
        ButtonZurueck = new JButton();
        ButtonZurueck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu = 1;
                ButtonLeicht.setVisible(false);
                ButtonMittel.setVisible(false);
                ButtonSchwer.setVisible(false);
                ButtonZurueck.setVisible(false);
                repaint();
            }
        });
    }

    //Button Init Menu3
    public void ButtonLLeise() {
        ButtonLLeise = new JButton();
        ButtonLLeise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menusoundstoppen();
                LautMinus=40;
                try {
                    Menusoundstarten();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
    public void ButtonLMittel(){
        ButtonLMittel= new JButton();
        ButtonLMittel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menusoundstoppen();
                LautMinus=20;
                try {
                    Menusoundstarten();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
    public void ButtonLLaut(){
        ButtonLLaut= new JButton();
        ButtonLLaut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menusoundstoppen();
                LautMinus=1;
                try {
                    Menusoundstarten();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
    public void ButtonZurueck2() {
        ButtonZurueck2 = new JButton();
        ButtonZurueck2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu = 1;
                ButtonLLeise.setVisible(false);
                ButtonLMittel.setVisible(false);
                ButtonLLaut.setVisible(false);
                repaint();
            }
        });
    }

    public void Menusoundstarten() throws Exception {
        menusound = new Sound("resources/sound/198896__bone666138__8-bit-circus-music.wav",LautMinus,true);
        menusound.playSound1();
    }
    public void Menusoundstoppen(){
        menusound.stopSound1();
    }
    public float getLautstärke(){
        return LautMinus;
    }
    public int getModus() {
        return modus;
    }
    public void setModus(int modus){
        this.modus=modus;
    }
    public void startFont() throws IOException, FontFormatException {       //Custom Font init
        File f = new File("resources/font/PressStart2P.ttf");       //Pfad zu .ttf File
        Font PressStart = Font.createFont(Font.TRUETYPE_FONT,f);                //Neue Font machen
        PressStart = PressStart.deriveFont(Font.PLAIN,20);                  //Größe, ... festlegen
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(PressStart);                                            //keine Ahnung
        retroFont = PressStart;                                                 //Abspeichern
    }
}
