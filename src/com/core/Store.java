package com.core;

import java.awt.*;

public class Store {
    private Pet[] merch;
    private int round;

    public Store(int r){
        round = r;
        merch = new Pet[3+(r-1)/3];
    }

    public void roll(){
        for(Pet p : merch){

        }
    }

    public void drawInShop(Graphics2D g, double xscale, double yscale){
        for(int i = 0; i < merch.length; i++){
            Pet p = merch[i];
            if(p != null){
                p.setLoc(.14+(.075*i), .4);
                p.draw(g,xscale*.9,yscale*.9);
            }
        }
    }
}
