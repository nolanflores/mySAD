package com.Window;

import com.Window.Scenes.splashScreen;
import com.utils.Keyboard;
import com.utils.Mouse;

import javax.swing.*;

public class Frame extends JFrame {
    private Panel current;
    public Frame(){
        setTitle("Super Auto Dunlea");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(new Keyboard());
        addMouseListener(Mouse.get());
        addMouseMotionListener(Mouse.get());
        setScreen(new splashScreen(this));
        pack();
        setLocationRelativeTo(null);
    }
    public void run(){
    }

    public void setScreen(Panel p){
        if(current != null)
            remove(current);
        current = p;
        add(p);
        setVisible(true);
    }
}
