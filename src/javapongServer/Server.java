package javapongServer;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {

    private ServerSocket serverSocket1;
    private ArrayList clientSockets;
    private int port=95;

    public Server() throws IOException, ClassNotFoundException {
        clientSockets = new ArrayList<Socket>();        //bestehende Verbindungen werden hier gespeichert
        System.out.println("TRest");
        serverSocket1 = new ServerSocket(port);

        while(true) {
            newVerbindung();            //auf neue Verbindungen warten
            zuweisen();                 //Mit 2 ein Spiel starten -> OnlineSpiel
        }                               //repeat

    }

    public void newVerbindung() throws IOException {
        Socket socket1 = serverSocket1.accept();        //Neue verbindungen abspeichern
        if(socket1!=null) {
            clientSockets.add(socket1);
        }
    }
    public void zuweisen() throws IOException, ClassNotFoundException {
        int s = clientSockets.size();
        System.out.println(s);
        if(s>0) {    //FixMe für debug nur 1 Spieler                             //Wenn 2 Spieler warten
            System.out.println("if");
            //Socket sock1 = (Socket) clientSockets.get(s);
            Socket sock1 = (Socket) clientSockets.get(s-1);

            OnlineSpiel ospiel1= new  OnlineSpiel(sock1);               //Spiel starten
            ospiel1.start();
        }

    }






}
