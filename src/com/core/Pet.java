package com.core;

import com.Window.Panel;

public class Pet extends Sprite{
    protected int tier;
    protected int damage;
    protected int health;

    protected Pet(String path, double x, double y, Panel p) {
        super(path, x, y, p);
    }

    public int getDamage(){
        return damage;
    }
    public int getHealth(){
        return health;
    }

    public void ability(){

    }
}
