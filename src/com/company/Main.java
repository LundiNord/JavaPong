package com.company;
import java.awt.EventQueue;

public class Main {

    public static void main(String[] args) {
	//System.out.println("Hallo");
        EventQueue.invokeLater(() -> {      //keine Ahnung wofür das ist
            Spiel spiel1 = new Spiel();
            spiel1.setVisible(true);
        });
    }
}
