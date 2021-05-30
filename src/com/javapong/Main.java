/* This file is part of JavaPong.
        JavaPong is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, either version 3 of the License, or
        (at your option) any later version.
        JavaPong is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        GNU General Public License for more details.
        You should have received a copy of the GNU General Public License
        along with JavaPong.  If not, see <https://www.gnu.org/licenses/>.
*/
package com.javapong;
import java.awt.EventQueue;
import java.util.Scanner;

//JavaPong by Jan,Ricardo,Leon

public class Main {

    public static void main(String[] args) throws Exception
    {
       EventQueue.invokeLater(() ->     //keine Ahnung wofür das ist
         {
            Spiel spiel1 = new Spiel();
            spiel1.setVisible(true);
        });

        //Sound s1 = new Sound();
        /*
        Storage s1 = new Storage();
        s1.write("Testgfdfgydfgd", 1);
        s1.write("Test2ygfdgfydfgy",2);
        Scanner scanner = new Scanner(System.in);
        char x = scanner.next().charAt(0);
        String y = String.valueOf(x);
        s1.write(y,2);
        System.out.println(s1.read(2)); */
    }
}