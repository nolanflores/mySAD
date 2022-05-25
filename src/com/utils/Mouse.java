package com.utils;

import com.core.Coordinate;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener {
    private static Mouse instance;
    private static Coordinate loc;
    private static boolean[] buttons = new boolean[3];

    private Mouse(){
        loc = new Coordinate();
    }

    public static Mouse get(){
        if(instance == null)
            instance = new Mouse();
        return Mouse.instance;
    }
    public static Coordinate Loc(){
        return loc;
    }
    public static boolean isPressed(int button){
        if(button >= 0 && button < 3)
            return buttons[button];
        return false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {
        if(e.getButton() >= 1 && e.getButton() <= 3)
            buttons[e.getButton()-1] = true;
    }
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() >= 1 && e.getButton() <= 3)
            buttons[e.getButton()-1] = false;
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        loc.set(e.getX(),e.getY());
    }
    public void mouseMoved(MouseEvent e) {
        loc.set(e.getX(),e.getY());
    }
}
