package com.core.Characters;

import com.Window.Panel;
import com.core.Pet;

public class NoPet extends Pet {

    public NoPet(double x, double y){
        super("Assets/pets/dot.png",x,y);
    }
    public NoPet(){
        this(-1,-1);
    }
}
