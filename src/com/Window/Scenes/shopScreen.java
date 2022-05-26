package com.Window.Scenes;

import com.Window.Frame;
import com.Window.Panel;
import com.core.Characters.Chorby;
import com.core.Image;
import com.core.Sprite;
import com.core.Team;

import java.awt.*;

public class shopScreen extends Panel {
    private static int round;
    private final int tier;
    private int gold;

    private Team team;
    private Sprite dot;
    private Image shopLabel;
    private Image teamLabel;

    public shopScreen(Frame f, Team t) {
        super(f);
        round++;
        tier = (round+1)/2;
        gold = 10;
        team = t;
        dot = new Sprite("Assets/shop/dot.png",-1,-1,this);
        shopLabel = new Image("Assets/shop/shoplabel.jpg",.05,.6,this);
        teamLabel = new Image("Assets/shop/teamlabel.jpg",.05,.42,this);
        t.setPet(0,new Chorby(this));
        t.setPet(1,new Chorby(this));
        //t.setPet(2,new Chorby(this));
        t.setPet(3,new Chorby(this));
        t.setPet(4,new Chorby(this));
        setBackground(new Color(14, 207, 69));
    }
    public shopScreen(Frame f) {
        this(f,new Team());
        round = 1;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        drawBackground(g2);
        team.drawInShop(g2,xscale,yscale);
        shopLabel.draw(g2,xscale,yscale);
        teamLabel.draw(g2,xscale,yscale);
    }

    private void drawBackground(Graphics2D g){
        g.setColor(new Color(139, 253, 250));
        g.fillRect(0,0,getWidth(),getHeight()/4);
        g.setColor(Color.BLACK);
        g.fillRect(0,getHeight()/4,getWidth(),getHeight()/100);

        for(int x = 0; x < 5; x++){
            dot.setLoc(.14+(.075*x),.425);
            dot.draw(g,(xscale/1.3)*.9,yscale/1.5);
        }
    }
}
