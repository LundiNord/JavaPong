package com.javapong;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.*;

public class Sound {            //ToDo: nicht getestet
    AudioInputStream audioInputStream1;
    Clip clip1;
    String Path1;
    private float LautstaerkeMinus;
    boolean looped;

    public Sound(String Path,float LautMinus,boolean looped) throws Exception {           //Clips initialisieren
        Path1 = Path;
        this.looped = looped;
        LautstaerkeMinus = LautMinus;
        clip1 = soundInit(Path1,false);
    }

    public void playSound1() {
        clip1.start();
    }
    public void stopSound1() {
        clip1.stop();
        //clip1.close();
    }
    public void playSoundOnce() {
        clip1.start();
        clip1.setFramePosition(0);        //reset zum start
    }
    public Clip soundInit(String Pfad,boolean looped) throws Exception {       //Sound initialisieren
        audioInputStream1 = AudioSystem.getAudioInputStream(new File(Pfad).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();  //Clip erzeugen. Mit Clips kann man Audio buffern und einfach loopen
        clip.open(audioInputStream1);
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-LautstaerkeMinus);

        if(looped ==true) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);     //loopen
        }
        return clip;
    }
}
