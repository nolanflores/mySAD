package com.core;

import com.core.Characters.NoPet;

import java.awt.*;

public class Store {
    private Pet[] merch = new Pet[3];
    private Item[] items = new Item[2];

    private Image dot;

    public Store(){
        roll();
        dot = new Image("Assets/pets/dot.png",-1,-1);
    }

    public void roll(){
        merch[0] = Pet.randomPet();
        merch[1] = Pet.randomPet();
        merch[2] = Pet.randomPet();
        items[0] = null;
        items[1] = Item.randomItem();
    }

    public Pet[] getMerch(){
        return merch;
    }

    public Item[] getItems(){
        return items;
    }

    public void drawInShop(Graphics2D g, double xscale, double yscale){
        dot.setLoc(.38,.565);
        dot.draw(g,xscale*.68,yscale*.7);
        dot.setLoc(.455,.565);
        dot.draw(g,xscale*.68,yscale*.7);
        for(int i = 0; i < 3; i++){
            Pet p = merch[i];
            p.setLoc(.14+(.075*i), .565);
            p.draw(g,xscale*.68,yscale*.7);
        }
        for(int x = 0; x < 2; x++){
            Item i = items[x];
            if(i != null){
                i.setLoc(.38+(.075*x), .565);
                i.draw(g,xscale*.68,yscale*.7);
            }
        }
    }
}
