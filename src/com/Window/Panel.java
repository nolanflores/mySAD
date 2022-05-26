package com.Window;

import com.core.Coordinate;
import com.utils.Keyboard;
import com.core.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Panel extends JPanel {
    private final int initialwidth, initialheight;
    protected Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    protected Coordinate center;
    protected int width, height;
    protected double xscale, yscale;

    private long last;
    public double dt;
    public int fps;

    protected Frame main;

    public Panel(Frame f){
        main = f;
        initialheight = 720;
        initialwidth = 1280;
        setPreferredSize(new Dimension(initialwidth, initialheight));
        width = this.getWidth();
        height = this.getHeight();
        center = new Coordinate(initialwidth/2,initialheight/2);
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
        xscale = (double)width/(double)initialwidth;
        yscale = (double)height/(double)initialheight;
        repaint();
    }
}
