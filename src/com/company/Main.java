package com.company;
import java.awt.EventQueue;

public class Main {

    public static void main(String[] args) {
	//System.out.println("Hallo");
        EventQueue.invokeLater(() -> {      //keine Ahnung wofür das ist
            SchiffMain app1 = new SchiffMain();
            app1.setVisible(true);
        });
    }
}
