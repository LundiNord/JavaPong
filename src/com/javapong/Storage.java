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


    public void write(String save, int zeile) throws IOException {

        //Instantiating the Scanner class to read the file
        Scanner sc = new Scanner(new File(Pfad));
        //instantiating the StringBuffer class
        StringBuffer buffer = new StringBuffer();
        //Reading lines of the file and appending them to StringBuffer
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine()+System.lineSeparator());
        }
        String fileContents = buffer.toString();
        //closing the Scanner object
        sc.close();
        String oldLine = read(zeile);
        String newLine = save;
        //Replacing the old line with new line
        fileContents = fileContents.replaceAll(oldLine, newLine);
        //instantiating the FileWriter class
        FileWriter writer = new FileWriter(Pfad);
        writer.write(fileContents);
        writer.flush();
    }



    public String read(int zeile) throws FileNotFoundException {
        String data = "Test";

            File myObj = new File(Pfad);
            Scanner myReader = new Scanner(myObj);
            for(int i =0; i<zeile;i++) {           //Linien im Dokument durchgehen bis int zeile
                data = myReader.nextLine();         //lesen
            }
            myReader.close();


        return data;
    }

}
