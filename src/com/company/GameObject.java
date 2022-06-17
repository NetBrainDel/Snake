package com.company;

import java.awt.*;

public enum GameObject {
    EMPTY(50,200,0),
    FOOD(200, 40,10),
    HEAD(0,30,250),
    TAIL(0,50,200),
    PORTAL(0,0,0);
    Color color;
    private GameObject(int r, int g, int b){
        color = new Color(r,g,b);
    }
    public Color getColor(){
        return color;
    }
}
