package Test;
import Test.AniBoard;

import javax.swing.JFrame;

public class App extends JFrame {

    public App() {

        startUI();
    }

    public void startUI() {
        add(new AniBoard());

        setResizable(false);
        pack();

        setSize(1000, 600);
        setTitle("Test Appp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);    //öffnet sich in der Mitte des Bildschirmes
    }


}

