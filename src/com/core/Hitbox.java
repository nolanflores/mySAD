package com.core;

import com.utils.Mouse;

public class Hitbox {
    private Coordinate[] coords = new Coordinate[4];

    public Hitbox(int x, int y, int w, int h){
        coords[0] = new Coordinate(x,y);            //top left
        coords[1] = new Coordinate(x+w,y);       //top right
        coords[2] = new Coordinate(x,y+h);       //bottom left
        coords[3] = new Coordinate(x+w,y+h);  //bottom right
    }

    public Coordinate[] getCoords() {
        return coords;
    }

    public boolean pointIn(Coordinate c){
        if(c.X() >= coords[0].X() && c.X() <= coords[1].X()){
            if(c.Y() >= coords[0].Y() && c.Y() <= coords[2].Y())
                return true;
        }
        return false;
    }
    public boolean collision(Hitbox h){
        for(Coordinate c : coords){
            if(h.pointIn(c))
                return true;
        }
        return false;
    }

    public boolean clickedOn(){
        return Mouse.isPressed(0) && pointIn(Mouse.Loc());
    }
}
