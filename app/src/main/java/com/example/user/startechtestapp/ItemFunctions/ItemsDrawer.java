package com.example.user.startechtestapp.ItemFunctions;

import java.util.List;

public class ItemsDrawer {
    public static void draw(List<Item> li, double tilt[])
    {
        for (Item it:li) {
            it.draw(tilt);
        }
    }
}
