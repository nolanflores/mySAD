package com.core;

import java.awt.*;

public class Store {
    private Pet[] merch = new Pet[3];
    private Item[] items;

    public Store(){
        roll();
    }

    public void roll(){
        merch[0] = Pet.randomPet();
        merch[1] = Pet.randomPet();
        merch[2] = Pet.randomPet();
    }

    public Pet[] getMerch(){
        return merch;
    }


    public void drawInShop(Graphics2D g, double xscale, double yscale){
        for(int i = 0; i < 3; i++){
            Pet p = merch[i];
            p.setLoc(.14+(.075*i), .565);
            p.draw(g,xscale*.68,yscale*.7);

        }
    }
}
