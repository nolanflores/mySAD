package com.Window.Scenes;

import com.Window.Frame;
import com.Window.Panel;
import com.core.*;
import com.core.Characters.Chorby;
import com.core.Characters.Minion;
import com.core.Image;
import com.utils.Mouse;

import java.awt.*;
import java.util.ArrayList;

public class shopScreen extends Panel {

    private Team team;
    private Store store;
    private Image teamLabel, shopLabel;

    private Image selector;
    private int selectIndex = -1, selectLoc = -1;
    private Sprite selected, ready;


    public shopScreen(Team t) {
        team = Team.randomTeam();
        store = new Store();
        selector = new Image("Assets/shop/Selector.png", -1,-1);
        shopLabel = new Image("Assets/shop/shoplabel.jpg",.05,.6);
        teamLabel = new Image("Assets/shop/teamlabel.jpg",.05,.4);
        ready = new Sprite("Assets/shop/ready.png",.825,.88);
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

        store.drawInShop(g2,xscale,yscale);
        team.drawInShop(g2,xscale,yscale);
        ready.draw(g2,xscale,yscale);
        shopLabel.draw(g2,xscale,yscale);
        teamLabel.draw(g2,xscale,yscale);
        selector.draw(g2,xscale,yscale);

        System.out.println(selectLoc+", "+selectIndex);

        if(ready.clickedOn() && team.hasPets())
            Frame.setScreen(new battleScreen());
    }

    private void setFocus(){
        if(Mouse.isPressed(0)){
            for(int i = 0; i < team.getPets().length+store.getMerch().length; i++){
                Pet p;
                if(i < team.getPets().length){
                    p = team.getPets()[i];
                    selectLoc = 0;
                    selectIndex = i;
                }
                else{
                    p = store.getMerch()[i-team.getPets().length];
                    selectLoc = 1;
                    selectIndex = i-team.getPets().length;
                }
                if(p.clickedOn()){
                    selector.setLoc(p.getX(),p.getY()+.016);
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

        }
    }

    private void drawBackground(Graphics2D g){
        g.setColor(new Color(139, 253, 250));
        g.fillRect(0,0,getWidth(),getHeight()/4);
        g.setColor(Color.BLACK);
        g.fillRect(0,getHeight()/4,getWidth(),getHeight()/100);
    }
}
