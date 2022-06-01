package com.Window;

import com.core.Coordinate;
import com.utils.Keyboard;
import com.core.Sprite;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    private final int INITIALWIDTH = 1280, INITIALHEIGHT = 720;
    //protected Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    protected Coordinate center;
    protected int width, height;
    protected double xscale, yscale;

    private long last;
    public double dt;
    public int fps;

    public Panel(){
        setPreferredSize(new Dimension(INITIALWIDTH, INITIALHEIGHT));
        width = this.getWidth();
        height = this.getHeight();
        center = new Coordinate(INITIALWIDTH/2,INITIALHEIGHT/2);
        last = System.nanoTime();
    }

    @Override
    public void paintComponent(Graphics g){
        long current = System.nanoTime();
        dt = (double)(current-last)/1_000_000;
        fps = (int)(1000/dt);
        last = current;
        super.paintComponent(g);
        width = this.getWidth();
        height = this.getHeight();
        center.set(width/2,height/2);
        xscale = (double)width/(double)INITIALWIDTH;
        yscale = (double)height/(double)INITIALHEIGHT;
        repaint();
    }
}
