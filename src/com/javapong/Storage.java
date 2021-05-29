package com.javapong;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Storage {      //Wir brauchen persistent storage
    private String Pfad = "src/resources/save/savefile.txt";

    public Storage() {

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

}
