package com.javapong;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class OSpiel  extends JFrame {           //Extrabehandlung des Online-Spiels

    private boolean spielstopp=false;
    private String address = "192.168.188.132";
    private int port= 95;
    private Socket socket1;     //Internet
    private PrintWriter senden;
    private BufferedReader empfangen;

    public OSpiel() throws IOException {
        initConnection();
        System.out.println("ServerTest");

    }
    public void initConnection() throws IOException {      //Verbindung mit Server Starten
        socket1 = new Socket(address,port);
        //Senden Init
        OutputStream rausStream = socket1.getOutputStream();
        senden = new PrintWriter(rausStream, true);
        //Empfangen Init
        InputStream inStream = socket1.getInputStream();  //Empfangen
        empfangen = new BufferedReader(new InputStreamReader(inStream));

        senden.println(500);


    }









    public boolean getSpielstopp(){
        return spielstopp;
    }
}
