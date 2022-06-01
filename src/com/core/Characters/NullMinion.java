package com.core.Characters;

import com.Window.Panel;
import com.core.Pet;

public class NullMinion extends Pet {
    public NullMinion(double x, double y){
        super("Assets/pets/Null.png",x,y);

    }
    public NullMinion(){
        this(-1,-1);
    }
}
