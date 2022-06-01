package com.core;

import com.Window.Panel;
import com.core.Characters.*;

public class Pet extends Sprite{
    protected int InitialHealth;
    protected int InitialDamage;
    protected int damage;
    protected int health;

    protected Item item;

    protected Pet(String path, double x, double y) {
        super(path, x, y);
    }

    public int getDamage(){
        return damage;
    }
    public int getHealth(){
        return health;
    }

    public void prepare(){
        damage = InitialDamage;
        health = InitialHealth;
    }

    public void addHealth(int dh){
        health += dh;
    }
    public void takeDamage(int dh){
        health -= dh;
    }
    public void addDamage(int dd){
        damage += dd;
    }

    public void onBuy(Pet[] team, int index){
    }
    public void onStart(Pet[] team, int index){
    }
    public void onTurn(Pet[] team, int index){
    }
    public void onDeath(Pet[] team, int index){
    }
    public void onSell(Pet[] team, int index){
    }



    public static Pet randomPet(){
        int chance = (int)(Math.random()*6);//6 is number of pets created
        switch (chance){
            case 0:
                return new Chorby();
            case 1:
                return new Horny();
            case 2:
                return new Minion();
            case 3:
                return new NullMinion();
            case 4:
                return new PurpleCup();
            case 5:
                return new Taxes();
            default:
                return null;
        }
    }
}
