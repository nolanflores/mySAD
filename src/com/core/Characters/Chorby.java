package com.core.Characters;

import com.Window.Panel;
import com.core.Pet;

public class Chorby extends Pet {

    public Chorby(double x, double y, Panel p){
        super("Assets/pets/Chorby.png",x,y,p);
        damage = 20;
        health = 1;
        tier = 5;
    }
    public Chorby(Panel p){
        this(-1,-1,p);
    }
}
