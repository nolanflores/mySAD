package com.core;

import com.core.Characters.Chorby;
import com.core.Characters.NoPet;

import java.awt.*;
import java.util.ArrayList;

public class Team {
    private Pet[] pets;

    public Team(){
        pets = new Pet[5];
        for(Pet p : pets){
            p = new NoPet();
        }
    }

    public void setPet(int index, Pet p){
        if(index >= 0 && index < 5) {
            if (pets[index] == null) {
                pets[index] = p;
            }
        }
    }

    public boolean hasPets(){
        for(Pet p : pets){
            if(!(p instanceof NoPet))
                return true;
        }
        return false;
    }

    public Pet[] getPets(){
        return pets;
    }

    public Pet getPet(int index){
        return pets[index];
    }

    public void drawInShop(Graphics2D g, double xscale, double yscale){
        for(int i = 0; i < 5; i++){
            Pet p = pets[i];
            if(p != null){
                p.setLoc(.14+(.075*i), .365);
                p.draw(g,xscale*.68,yscale*.7);
            }
        }
    }

    public void drawInBattle(Graphics2D g, double xscale, double yscale){
        int ind = 0;
        for(int i = 4; i >= 0; i--){
            Pet p = pets[i];
            if(p != null){
                p.setLoc(.44-(.075*ind), .4);
                p.draw(g,xscale*.9,yscale*.9);
                ind++;
            }
        }
    }

    public static Team randomTeam(){
        Team t = new Team();
        t.setPet(0,Pet.randomPet());
        t.setPet(1,Pet.randomPet());
        t.setPet(2,Pet.randomPet());
        t.setPet(3,Pet.randomPet());
        t.setPet(4,Pet.randomPet());
        return t;
    }
}
