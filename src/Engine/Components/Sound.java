package Engine.Components;

import java.io.*;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
    Clip clip;
    
    //Just one sound
    File Sound;

    //Many Sounds
    Dictionary<String,File> Sounds = new Hashtable<>();

    public Sound(String SoundDir){
        Sound = new File(SoundDir);
    };

    public Sound(String [] names, String[] F){
        for(int i = 0; i < names.length; i++){
            File file = new File(F[i]); 
            Sounds.put(names[i],file);
        }
    }

    public void GetSound(String name){
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(Sounds.get(name));
            clip = AudioSystem.getClip();
            clip.open(audio);
        } catch (UnsupportedAudioFileException | IOException |LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play(String name){
        GetSound(name);
        clip.start();
    }

    public void loop(String name){
        GetSound(name);
        clip.loop(clip.LOOP_CONTINUOUSLY);
    }

    public void stop(String name) {
        GetSound(name);
        clip.stop(); 
    }
}
