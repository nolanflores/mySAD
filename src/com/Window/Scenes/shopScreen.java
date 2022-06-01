package com.Window.Scenes;

import com.Window.Frame;
import com.Window.Panel;
import com.core.Characters.Chorby;
import com.core.Characters.Minion;
import com.core.Image;
import com.core.Pet;
import com.core.Sprite;
import com.core.Team;
import java.awt.*;
import java.util.ArrayList;

public class shopScreen extends Panel {

    private Team team;
    private Image teamLabel, shopLabel;

    public shopScreen(Team t) {
        team = Team.randomTeam();
        shopLabel = new Image("Assets/shop/shoplabel.jpg",.05,.6,this);
        teamLabel = new Image("Assets/shop/teamlabel.jpg",.05,.4,this);
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

        team.drawInShop(g2,xscale,yscale);
        shopLabel.draw(g2,xscale,yscale);
        teamLabel.draw(g2,xscale,yscale);

    }

    private void drawBackground(Graphics2D g){
        g.setColor(new Color(139, 253, 250));
        g.fillRect(0,0,getWidth(),getHeight()/4);
        g.setColor(Color.BLACK);
        g.fillRect(0,getHeight()/4,getWidth(),getHeight()/100);
    }
}
