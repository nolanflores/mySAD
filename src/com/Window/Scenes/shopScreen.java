package com.Window.Scenes;

import com.Window.Frame;
import com.Window.Panel;

import java.awt.*;

public class shopScreen extends Panel {
    public shopScreen(Frame f) {
        super(f);
        setBackground(new Color(139, 253, 250));
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
    }

    private void drawBackground(Graphics2D g){

    }
}
