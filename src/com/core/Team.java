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
            }
        }
    }

    public Pet getPet(int index){
        return pets[index];
    }

    public void drawInShop(Graphics2D g, double xscale, double yscale){
        for(int i = 0; i < 5; i++){
            Pet p = pets[i];
            if(p != null){
                p.setLoc(.14+(.075*i), .4);
                p.draw(g,xscale*.9,yscale*.9);
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
}
