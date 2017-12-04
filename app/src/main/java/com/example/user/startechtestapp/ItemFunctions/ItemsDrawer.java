package com.example.user.startechtestapp.ItemFunctions;

import java.util.List;

public class ItemsDrawer {
    public void drawItemsList(List<Item> li, double tilt[])
    {
        for (Item it:li) {
            it.draw(tilt);
        }
    }
    public void drawItem(Item it, double tilt[])
    {
        if(it!=null) {
            it.draw(tilt);
        }
    }
}
