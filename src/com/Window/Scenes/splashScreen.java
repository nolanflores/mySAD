package com.Window.Scenes;

import com.Window.Frame;
import com.Window.Panel;
import com.core.Sprite;
import com.utils.Mouse;
import com.utils.Sound;

import java.awt.*;


public class splashScreen extends Panel {
    Sprite logo;
    Sound cry;
    public splashScreen(Frame f){
        super(f);
        setBackground(Color.BLACK);
        logo = new Sprite("assets/diapergames.jpg", .5,.5, this);
        cry = new Sound("assets/baby.wav");
        cry.play();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        logo.draw(g2,xscale/2,yscale/2);
        if(logo.clickedOn()){
            System.exit(0);
        }
        if(!cry.isPlaying) {
            main.setScreen(new mainMenu(main));
        }
    }
}
