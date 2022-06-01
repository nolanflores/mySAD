package com.core.Characters;

import com.Window.Panel;
import com.core.Pet;

public class Minion extends Pet {

    public Minion(double x, double y) {
        super("Assets/pets/Minion.png", x, y);
    }
    public Minion(){
        this(-1,-1);
    }
}
