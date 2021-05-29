package com.javapong;
import java.awt.EventQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception
    {
       //EventQueue.invokeLater(() ->     //keine Ahnung wofür das ist
        // {
        //    Spiel spiel1 = new Spiel();
        //    spiel1.setVisible(true);
        //});

        //Sound s1 = new Sound();
        Storage s1 = new Storage();
        s1.write("Testgfdfgydfgd", 1);
        s1.write("Test2ygfdgfydfgy",2);
        Scanner scanner = new Scanner(System.in);
        char x = scanner.next().charAt(0);
        String y = String.valueOf(x);
        s1.write(y,2);
        System.out.println(s1.read(2));
    }
}