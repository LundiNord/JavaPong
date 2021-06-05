package javapongServer;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class OnlineSpiel extends Thread{        //ein Thread für fortlaufende Action

    private Socket sock1;
    private Socket sock2;       //FixMe: für debug nur 1 Spieler
    private ArrayList inSpieler1;       //Die Kommunikation funktioniert über Arrays die immer alle Daten enthalten
    private ArrayList inSpieler2;       //ToDo: ArrayList durch normale int Arrays austauschen
    private ArrayList outSpieler1;
    private ArrayList outSpieler2;
    ObjectInputStream in1;
    ObjectInputStream in2;
    ObjectOutputStream out1;
    ObjectOutputStream out2;

    public OnlineSpiel(Socket sock1) throws IOException, ClassNotFoundException {
        this.sock1 = sock1;
        this.sock2 = sock2;
        in1 = new ObjectInputStream(sock1.getInputStream());
        //in2 = new ObjectInputStream(sock2.getInputStream());
        out1 = new ObjectOutputStream(sock1.getOutputStream());
        //out2 = new ObjectOutputStream(sock2.getOutputStream());

        System.out.println("Thread");

        //System.out.println(inSpieler1.get(0));
    }
    @Override
    public void run() {         //Diese Methode wird vom Thread immer wieder ausgeführt
        long beforeTime, timeDiff, sleep;           //Wir wollen das sie alle 16ms ausgeführt wird (jeden Frame)
        beforeTime = System.currentTimeMillis();
        //Eigentlicher Code
        try {                   //Empfangen
            empfangen();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //work
        outSpieler1=inSpieler1;
        System.out.println("ImThread");
        System.out.println(outSpieler1.get(0));

        try {           //Senden
            senden();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Ende
        timeDiff = System.currentTimeMillis() - beforeTime;     //mehr Timing
        sleep = 16 - timeDiff;                    //delay
        if (sleep < 0) {
            sleep = 2;
        }
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {              //Error handling
            String msg = String.format("Thread interrupted: %s", e.getMessage());
            JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
        }
        beforeTime = System.currentTimeMillis();        //Timing reset
    }

    public void empfangen() throws IOException, ClassNotFoundException {
        inSpieler1 = (ArrayList) in1.readObject();
        //inSpieler2 = (ArrayList) in2.readObject();
    }
    public void senden() throws IOException {
        out1.writeObject(outSpieler1);
        //out2.writeObject(outSpieler2);
    }





    public void testRecive() throws IOException, ClassNotFoundException {

        InputStream istream = sock1.getInputStream();
        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
        String receiveMessage, sendMessage;


        ObjectInputStream in = new ObjectInputStream(sock1.getInputStream());

        ArrayList y = (ArrayList) in.readObject();
        System.out.println(y.get(0));
    }
}
