package com.core;

import com.core.Characters.*;
import com.core.Items.House;

public class Item extends Sprite{
    public Item(String path, double x, double y) {
        super(path, x, y);
    }

    public void onBuy(Pet owner){
    }
    public void onStart(Pet owner){
    }
    public void onTurn(Pet owner){
    }
    public void onDeath(Pet owner){
    }
    public void onSell(Pet owner){
    }

    public static Item randomItem(){
        int chance = (int)(Math.random()*1);//6 is number of pets created
        switch (chance){
            case 0:
                return new House();
            default:
                return null;
        }
    }
}
