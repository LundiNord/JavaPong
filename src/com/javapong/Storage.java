package com.javapong;

import java.awt.*;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Storage {                  //Wir brauchen persistent storage die leicht Veränderbar ist.
    private String Pfad = "resources/save/savefile.conf";

    public Storage() {

    }
    public void InitStorage() {             //Bei uns wird diese Methode auch nicht gebraucht
        File f = new File(Pfad);            //Initialisierung der Savefile
        if(!f.exists()) {                   //Wenn sie nicht existiert wird eine default generiert
            try {
                FileWriter myWriter = new FileWriter(Pfad);
                myWriter.write("test1 \n test2 \n test3 \n test4");     //Defaults
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }
    public void write(String save, int zeile) throws IOException {          //Schreiben
        Scanner sc = new Scanner(new File(Pfad));        //Scanner um die File einzulesen
        //Idee geklaut aus einem Tutorial
        StringBuffer buffer = new StringBuffer();
        while (sc.hasNextLine()) {                      //alle Linien des Dokuments zwischenspeichern
            buffer.append(sc.nextLine()+System.lineSeparator());
        }
        String fileContents = buffer.toString();    //buffer in einen String umwandeln
        sc.close();
        String oldLine = read(zeile);       //Zeile zum ersetzen zwischenspeichern
        String newLine = save;
        fileContents = fileContents.replaceAll(oldLine, newLine);   //alte mit Regex mit der neuen ersetzen
        //FixMe: Regex funkt bei gleichen Farbe nicht, wir müssten Identifier davor packen
        FileWriter writer = new FileWriter(Pfad);                   //File writer erzeugen
        writer.write(fileContents);                                 //Modifizierter String in Dokument speichern
        writer.flush();
    }
    public String read(int zeile) throws FileNotFoundException {        //Lesen
        String data = "Test";       //Ohne funktioniert nicht??
        File myObj = new File(Pfad);
        Scanner myReader = new Scanner(myObj);
        for(int i =0; i<zeile;i++) {           //Linien im Dokument durchgehen bis int zeile
            data = myReader.nextLine();         //lesen
        }
        myReader.close();
        return data;
    }
    //Getter/Setter Methoden
    public int readInt(int zeile) throws FileNotFoundException {
        return Integer.parseInt(read(zeile));
    }
    public float readFloat(int zeile) throws FileNotFoundException {
        return Float.parseFloat(read(zeile));
    }
    public Color readFarbe(int zeile) {
        Color farbe1;           //String to Farbe straight aus StackOverflow
        try {
            Field field = Class.forName("java.awt.Color").getField(read(zeile));
            farbe1 = (Color)field.get(null);
        } catch (Exception e) {
            farbe1 = Color.white; // Not defined
        }
        return farbe1;
    }
    public void writeFloat(float save, int zeile) throws IOException {
        String s = String.valueOf(save);        //Umwandeln
        write(s,zeile);
    }
    public void writeColour(Color c, int zeile) throws IOException {    //FixMe: bei gleichen Farben geht Regex schief
        //Es wäre schlauer gewesen die Farben als RGB Werte zu speichern und nur beim Input umzuwandeln... egal
        for (Field f : Color.class.getFields()) {                 //alle Farbnamen werden durchgegangen
            try {
                if (f.getType() == Color.class && f.get(null).equals(c)) {      //die Richtige wird ausgegeben
                    write(f.getName(), zeile);
                    //System.out.println(f.getName());
                }
            } catch (java.lang.IllegalAccessException e) {
                //hier sollte das Programm nie landen...
            }
        }
    }
}