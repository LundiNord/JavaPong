package javapongServer;
import java.io.*;
import java.net.*;

public class OnlineSpiel extends Thread{

    private Socket sock1;
    private Socket sock2;

    public OnlineSpiel(Socket sock1,Socket sock2) throws IOException {
        this.sock1 = sock1;
        this.sock2 = sock2;

        testRecive();
    }





    public void testRecive() throws IOException {

        InputStream istream = sock1.getInputStream();
        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
        String receiveMessage, sendMessage;
        while(true) {
            if((receiveMessage = receiveRead.readLine()) != null)
            {
                System.out.println(receiveMessage);
            }

        }


    }
}
