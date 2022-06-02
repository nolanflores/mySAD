package com.core;

import com.Window.Frame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Image {
    private BufferedImage texture;
    private double relativeX, relativeY;//relative meaning 1 is max and 0 is min
    private int width, height;

    public Image(String path, double x, double y){
        relativeX = x;
        relativeY = y;
        try {
            texture = ImageIO.read(new File(path));
        }catch(Exception e){
            e.printStackTrace();
        }
        width = texture.getWidth();
        height = texture.getHeight();
    }

    public void draw(Graphics2D g, double xscale, double yscale){
        int xcor = (int)(relativeX * Frame.current.getWidth());
        int ycor = (int)(relativeY * Frame.current.getHeight());
        width = (int)(texture.getWidth()*xscale);
        height = (int)(texture.getHeight() * yscale);
        g.drawImage(texture,(int)xcor-width/2,(int)ycor-height/2, width, height, Frame.current);
    }

    public void setLoc(double rx, double ry){
        relativeX = rx;
        relativeY = ry;
    }

    public static BufferedImage textToImage(String text){
        BufferedImage img = new BufferedImage(1,1,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setFont(new Font("Arial",Font.PLAIN,12));
        FontMetrics fm = g2.getFontMetrics();
        int width = fm.stringWidth(text);
        int height = fm.getHeight();
        g2.dispose();
        img = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        g2 = img.createGraphics();
        fm = g2.getFontMetrics();
        g2.setColor(Color.WHITE);
        g2.drawString(text, 0, fm.getAscent());
        g2.dispose();
        return img;
    }
}
