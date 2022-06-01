package com.core.Characters;

import com.Window.Panel;
import com.core.Pet;

public class Chorby extends Pet {

    public Chorby(double x, double y){
        super("Assets/pets/Chorby.png",x,y);
        damage = 20;
        health = 1;
    }
    public Chorby(){
        this(-1,-1);
    }
}
