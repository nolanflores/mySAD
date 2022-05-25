package com.core;

import com.core.Characters.Chorby;

import java.awt.*;
import java.util.ArrayList;

public class Team {
    private Pet[] pets;

    public Team(){
        pets = new Pet[5];
    }

    public void setPet(int index, Pet p){
        if(index >= 0 && index < 5) {
            if (pets[index] == null) {
                pets[index] = p;
                switch(index){
                    case 0:
                        p.setLoc(.1,.4);
                        break;
                    case 1:
                        p.setLoc(.2,.4);
                        break;
                    case 2:
                        p.setLoc(.3,.4);
                        break;
                    case 3:
                        p.setLoc(.4,.4);
                        break;
                    case 4:
                        p.setLoc(.5,.4);
                        break;
                }
            }
        }
    }

    public Pet getPet(int index){
        return pets[index];
    }

    public void drawPets(Graphics2D g, double xscale, double yscale){
        for(Pet p : pets){
            if(p != null){
                p.draw(g,xscale,yscale);
            }
        }
    }
}
