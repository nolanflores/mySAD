package com.Window;

import com.Window.Scenes.splashScreen;
import com.utils.Keyboard;
import com.utils.Mouse;

import javax.swing.*;

public class Frame extends JFrame {

    private static Frame main;
    public static Panel current;

    public Frame(){
        main = this;
        setTitle("Super Auto Dunlea");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(new Keyboard());
        setScreen(new splashScreen());
        pack();
        setLocationRelativeTo(null);
    }

    public static void setScreen(Panel p){
        Mouse.refresh();
        if(current != null)
            main.remove(current);
        current = p;
        main.add(p);
        p.addMouseListener(Mouse.get());
        p.addMouseMotionListener(Mouse.get());
        main.setVisible(true);
    }
}
