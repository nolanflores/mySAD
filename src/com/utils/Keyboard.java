package com.utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
    private static boolean[] keys = new boolean[500];

    public static boolean isPressed(int keyCode){
        if(keyCode >= 0 && keyCode < 500)
            return keys[keyCode];
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() >= 0 && e.getKeyCode() < 500)
            keys[e.getKeyCode()] = true;
    }
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() >= 0 && e.getKeyCode() < 500)
            keys[e.getKeyCode()] = false;
    }
}
