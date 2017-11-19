package com.example.user.startechtestapp;

import java.util.List;

class ItemsDrawer {
    static void draw(List<Item> li, double tilt[])
    {
        for (Item it:li) {
            it.draw(tilt);
        }
    }
}
