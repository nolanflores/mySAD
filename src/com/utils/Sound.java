package com.utils;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import java.io.File;

public class Sound {
    private Clip clip;
    public boolean isPlaying;

    public Sound(String path){
        try{
            File file = new File(path);
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch(Exception e){
            e.printStackTrace();
        }
        clip.addLineListener(e -> {
            if(e.getType() == LineEvent.Type.STOP){
                isPlaying = false;
            }
        });
    }

    public void play(){
        isPlaying = true;
        clip.setFramePosition(0);
        clip.start();
    }
}
