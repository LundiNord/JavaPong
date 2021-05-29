package Test;

import javax.swing.JFrame;

public class SchiffMain extends JFrame {

    public SchiffMain() {
        startUI();
    }
    public void startUI() {
        add(new SchiffBord());
        setTitle("Moving sprite");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

}
