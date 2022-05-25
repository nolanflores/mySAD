package com.core;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import com.Window.Panel;

public class Sprite {
    private Panel panel;
    private BufferedImage texture;
    private Hitbox hitbox;
    private double relativeX, relativeY, xcor, ycor;//relative meaning 1 is max and 0 is min
    private int width, height;

    public Sprite(String path, double x, double y, Panel p){
        panel = p;
        relativeX = x;
        relativeY = y;
        try {
            texture = ImageIO.read(new File(path));
        }catch(Exception e){
            e.printStackTrace();
        }
        width = texture.getWidth();
        height = texture.getHeight();
        hitbox = new Hitbox((int)x-width/2,(int)y-height/2,width,height);
    }

    public void draw(Graphics2D g, double xscale, double yscale){
        xcor = relativeX * panel.getWidth();
        ycor = relativeY * panel.getHeight();
        width = (int)(texture.getWidth()*xscale);
        height = (int)(texture.getHeight() * yscale);
        hitbox = new Hitbox((int)xcor-width/2,(int)ycor-height/2, width, height);
        g.drawImage(texture,(int)xcor-width/2,(int)ycor-height/2, width, height, panel);
    }

    public Hitbox Hitbox(){
        return hitbox;
    }

    public boolean clickedOn(){
        return hitbox.clickedOn();
    }
}
