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
    private Sprite selected;


    public shopScreen(Team t) {
        team = Team.randomTeam();
        store = new Store();
        selector = new Image("Assets/shop/Selector.png", -1,-1);
        shopLabel = new Image("Assets/shop/shoplabel.jpg",.05,.6);
        teamLabel = new Image("Assets/shop/teamlabel.jpg",.05,.4);
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

        store.drawInShop(g2,xscale,yscale);
        team.drawInShop(g2,xscale,yscale);
        shopLabel.draw(g2,xscale,yscale);
        teamLabel.draw(g2,xscale,yscale);
        selector.draw(g2,xscale,yscale);

        setFocus();
        if(selected != null)
            System.out.println(selected.getClass());
        else
            System.out.println("None selected");
    }

    private void setFocus(){
        if(Mouse.isPressed(0)){
            for(int i = 0; i < team.getPets().length+store.getMerch().length; i++){
                Pet p;
                if(i < team.getPets().length){
                    p = team.getPets()[i];
                }
                else{
                    p = store.getMerch()[i-team.getPets().length];

                }
                if(p.clickedOn()){
                    selector.setLoc(p.getX(),p.getY()+.016);
                    selected = p;
                    break;
                }
                else{
                    selector.setLoc(-1,-1);
                    selected = null;
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
