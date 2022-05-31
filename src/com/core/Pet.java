package com.core;

import com.Window.Panel;

public class Pet extends Sprite{
    protected int tier;
    protected int InitialHealth;
    protected int InitialDamage;
    protected int damage;
    protected int health;

    protected Item item;

    protected Pet(String path, double x, double y, Panel p) {
        super(path, x, y, p);
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
}
