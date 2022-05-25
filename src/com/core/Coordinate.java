package com.core;

public class Coordinate {
    private int x, y;
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Coordinate(){
        this.x = 0;
        this.y = 0;
    }

    public void set(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public void change(int dx, int dy){
        x += dx;
        y += dy;
    }
    public void changeX(int dx){
        x += dx;
    }
    public void changeY(int dy){
        y += dy;
    }

    public int X(){
        return x;
    }
    public int Y(){
        return y;
    }
}
