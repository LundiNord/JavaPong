package com.javapong;
//https://stackoverflow.com/questions/26305/how-can-i-play-sound-in-java

import java.net.URL;
import javax.swing.*;
import javax.sound.sampled.*;

public class Sound {            //ToDo: funktioniert noch nicht

    public Sound() throws Exception {
        sound1();   //testing
    }

    public void sound1() throws Exception {
            URL url = new URL("http://pscode.org/media/leftright.wav");
            Clip clip = AudioSystem.getClip();
            // getAudioInputStream() also accepts a File or InputStream
            AudioInputStream ais = AudioSystem.getAudioInputStream(url);
            clip.open(ais);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            SwingUtilities.invokeLater(() -> {
                // A GUI element to prevent the Clip's daemon Thread
                // from terminating at the end of the main()
                JOptionPane.showMessageDialog(null, "Close to exit!");
            });


}


}
