package com.core;

import com.Window.Frame;
import com.Window.Panel;
import com.core.Characters.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Pet extends Sprite{
    protected int InitialHealth;
    protected int InitialDamage;
    protected int damage;
    protected int health;

    protected Item item;

    private Image heart, attack;

    protected Pet(String path, double x, double y) {
        super(path, x, y);
        heart = new Image("Assets/pets/Heart.png",-1,-1);
        attack = new Image("Assets/pets/Attack.png",-1,-1);
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

    @Override
    public void draw(Graphics2D g, double xscale, double yscale) {
        super.draw(g, xscale, yscale);
        if(!(this instanceof NoPet)){
            BufferedImage h = Image.textToImage(""+health);
            BufferedImage d = Image.textToImage(""+damage);
            heart.setLoc(getX()+.021,getY()+.055);
            heart.draw(g,xscale,yscale);
            attack.setLoc(getX()-.021,getY()+.055);
            attack.draw(g,xscale,yscale);
            g.drawImage(h,(int)(Frame.current.getWidth()*(getX()+.0155))-h.getWidth()/2,(int)(Frame.current.getHeight()*(getY()+.028)), (int)(h.getWidth()*xscale*3),(int)(h.getHeight()*yscale*3),Frame.current);
            g.drawImage(d,(int)(Frame.current.getWidth()*(getX()-.026))-d.getWidth()/2,(int)(Frame.current.getHeight()*(getY()+.03)), (int)(d.getWidth()*xscale*3),(int)(d.getHeight()*yscale*3),Frame.current);
        }
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
