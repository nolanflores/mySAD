package com.core.Items;

import com.core.Item;

public class House extends Item {
    public House(double x, double y) {
        super("Assets/Items/House.png", x, y);
    }
    public House(){
        super("Assets/Items/House.png", -1, -1);
    }
}
