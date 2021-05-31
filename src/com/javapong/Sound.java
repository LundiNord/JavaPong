package com.javapong;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {            //ToDo: nicht getestet
    AudioInputStream audioInputStream1;
    Clip clip1;
    String Path1 = "src/resources/sound/198896__bone666138__8-bit-circus-music.wav";
    Clip clip2;
    String Path2 = null;    //ToDo: Sound hinzufügen

    public Sound() throws Exception {           //Clips initialisieren
        clip1 = soundInit(Path1,false);
    }

    public void playSound1() {
        clip1.start();
    }
    public void stopSound1() {
        clip1.stop();
        //clip1.close();
    }


    public Clip soundInit(String Pfad,boolean looped) throws Exception {       //Sound initialisieren
        audioInputStream1 = AudioSystem.getAudioInputStream(new File(Pfad).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();  //Clip erzeugen. Mit Clips kann man Audio buffern und einfach loopen
        clip.open(audioInputStream1);
        if(looped ==true) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);     //loopen
        }
        return clip;
    }
}
