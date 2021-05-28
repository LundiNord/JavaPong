package com.company;
import java.awt.EventQueue;

public class Main {

    public static void main(String[] args) {
	//System.out.println("Hallo");
        EventQueue.invokeLater(() -> {
            App app1 = new App();
            app1.setVisible(true);
        });
    }
}
