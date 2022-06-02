package com.Window.Scenes;

import com.Window.Frame;
import com.Window.Panel;
import com.core.*;
import com.core.Characters.Chorby;
import com.core.Characters.Minion;
import com.core.Characters.NoPet;
import com.core.Image;
import com.utils.Mouse;

import java.awt.*;
import java.util.ArrayList;

public class shopScreen extends Panel {

    private int gold;

    private Team team;
    private Store store;
    private Image teamLabel, shopLabel;

    private Image selector;
    private int selectIndex = -1, selectLoc = -1;
    private Sprite selected, ready, roll,goldlabel;

    private long rollCooldown;

    public shopScreen(Team t) {
        gold = 10;
        team = Team.randomTeam();
        store = new Store();
        roll = new Sprite("Assets/shop/Roll.png",.15,.9);
        goldlabel = new Sprite("Assets/shop/gold.png",.065,.07);
        selector = new Image("Assets/shop/Selector.png", -1,-1);
        shopLabel = new Image("Assets/shop/shoplabel.jpg",.05,.6);
        teamLabel = new Image("Assets/shop/teamlabel.jpg",.05,.4);
        ready = new Sprite("Assets/shop/ready.png",.85,.9);
        setBackground(new Color(14, 207, 69));
    }
    public shopScreen() {
        this(new Team());
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        drawBackground(g2);

        setFocus();

        goldlabel.draw(g2,xscale,yscale);
        roll.draw(g2,xscale*.8,yscale*.8);
        store.drawInShop(g2,xscale,yscale);
        team.drawInShop(g2,xscale,yscale);
        ready.draw(g2,xscale*.8,yscale*.8);
        shopLabel.draw(g2,xscale,yscale);
        teamLabel.draw(g2,xscale,yscale);
        selector.draw(g2,xscale,yscale);


        if(roll.clickedOn() && System.nanoTime()-rollCooldown>700000000 && gold > 0){
            gold--;
            store.roll();
            rollCooldown = System.nanoTime();
        }

        if(ready.clickedOn() && team.hasPets())
            Frame.setScreen(new battleScreen());
    }

    private void setFocus(){
        if(Mouse.isPressed(0)){
            for(int i = 0; i < 10; i++){
                Sprite p;
                if(i < 5){
                    p = team.getPets()[i];
                    selectLoc = 0;
                    selectIndex = i;
                }
                else if(i < 8){
                    p = store.getMerch()[i-5];
                    selectLoc = 1;
                    selectIndex = i-5;
                }
                else{
                    p = store.getItems()[i-8];
                    selectLoc = 2;
                    selectIndex = i -8;
                }
                if(p != null) {
                    if (p.clickedOn() && (selectLoc != 1 || !(p instanceof NoPet))) {
                        selector.setLoc(p.getX(), p.getY() + .016);
                        selected = p;
                        break;
                    }
                    else{
                        selector.setLoc(-1,-1);
                        selected = null;
                        selectLoc = -1;
                        selectIndex = -1;
                    }
                }
                else{
                    selector.setLoc(-1,-1);
                    selected = null;
                    selectLoc = -1;
                    selectIndex = -1;
                }
            }

        }
    }

    private void drawBackground(Graphics2D g){
        g.setColor(new Color(139, 253, 250));
        g.fillRect(0,0,getWidth(),getHeight()/4);
        g.setColor(Color.BLACK);
        g.fillRect(0,getHeight()/4,getWidth(),getHeight()/100);
    }
}
