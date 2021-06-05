package javapongServer;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {

    private ServerSocket serverSocket1;
    private ArrayList clientSockets;
    private int port=95;

    public Server() throws IOException {
        clientSockets = new ArrayList<Socket>();        //bestehende Verbindungen werden hier gespeichert
        System.out.println("TRest");
        serverSocket1 = new ServerSocket(port);

        while(true) {
            newVerbindung();
            zuweisen();
        }

    }

    public void newVerbindung() throws IOException {
        Socket socket1 = serverSocket1.accept();        //Neue verbindungen abspeichern
        if(socket1!=null) {
            clientSockets.add(socket1);
        }
    }
    public void zuweisen() throws IOException {
        int s = clientSockets.size();
        System.out.println(s);
        if(s>1) {                                              //Wenn 2 Spieler warten
            Socket sock1 = (Socket) clientSockets.get(s);
            Socket sock2 = (Socket) clientSockets.get(s-1);
            new OnlineSpiel(sock1,sock2).start();               //Spiel starten
        }

    }






}
