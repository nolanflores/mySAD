package com.Window.Scenes;

import com.Window.Frame;
import com.Window.Panel;
import com.core.Characters.Chorby;
import com.core.Sprite;
import com.core.Team;

import java.awt.*;

public class shopScreen extends Panel {
    private Team team;
    private Sprite dot;

    public shopScreen(Frame f, Team t) {
        super(f);
        team = t;
        dot = new Sprite("Assets/dot.png",-1,-1,this);
        t.setPet(0,new Chorby(this));
        t.setPet(1,new Chorby(this));
        t.setPet(2,new Chorby(this));
        t.setPet(3,new Chorby(this));
        t.setPet(4,new Chorby(this));
        setBackground(new Color(14, 207, 69));
    }
    public shopScreen(Frame f) {
        this(f,new Team());
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        drawBackground(g2);
        team.drawPets(g2,xscale,yscale);
    }

    private void drawBackground(Graphics2D g){
        g.setColor(new Color(139, 253, 250));
        g.fillRect(0,0,getWidth(),getHeight()/4);
        g.setColor(Color.BLACK);
        g.fillRect(0,getHeight()/4,getWidth(),getHeight()/100);
        for(double x = .1; x <= .5; x+=.1){
            dot.setLoc(x,.43);
            dot.draw(g,xscale/1.3,yscale/1.5);
        }
    }
}
