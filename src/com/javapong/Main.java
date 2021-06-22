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
import java.awt.*;

//JavaPong by Jan,Ricardo,Leon
/*
        //
 */

public class Main {

    public static void main(String[] args) throws Exception
    {
       EventQueue.invokeLater(() ->
         {
             Menu menu1 = null;
             try {
                 menu1 = new Menu();
             } catch (Exception e) {
                 e.printStackTrace();
             }
             menu1.setVisible(true);
        });
    }
}