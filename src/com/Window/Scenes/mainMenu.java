package com.Window.Scenes;


import com.Window.Panel;
import com.Window.Frame;
import com.core.Sprite;
import com.utils.Mouse;

import javax.swing.*;
import java.awt.*;

public class mainMenu extends Panel {
    Sprite sun;
    Sprite title;
    Sprite playButton;
    boolean isDay;
    public mainMenu(Frame f){
        super(f);
        setBackground(new Color(139, 253, 250));
        title = new Sprite("Assets/menu/title.png",.5,.2, this);
        sun = new Sprite("Assets/menu/sun.png", .9,.1, this);
        playButton = new Sprite("Assets/menu/menuOption.png",.5,.6,this);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        colorBackground(g2);
        title.draw(g2,xscale, yscale);
        if(sun.clickedOn()){
            isDay = false;
            setBackground(new Color(14, 9, 23));
            sun = new Sprite("Assets/menu/moon.png", .9,.1, this);
        }
        else{
            isDay = true;
            setBackground(new Color(139, 253, 250));
            sun = new Sprite("Assets/menu/sun.png", .9,.1, this);
        }
        sun.draw(g2,xscale,yscale);
        playButton.draw(g2,xscale/1.75,yscale/1.75);
        if(playButton.clickedOn()){
            main.setScreen(new shopScreen(main));
        }
    }


    private void colorBackground(Graphics2D g){
        if(isDay)
            g.setColor(new Color(14, 207, 69));
        else
            g.setColor(new Color(4, 91, 28));
        g.fillRect(0,getHeight(),getWidth(),-getHeight()/3);
        g.setColor(Color.BLACK);
        g.fillRect(0,getHeight()-getHeight()/3,getWidth(),getHeight()/100);
    }
}
