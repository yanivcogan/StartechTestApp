package com.example.user.startechtestapp;

import android.util.Log;

import java.util.List;

/**
 * Created by User on 01/10/2017.
 */

public class ItemsDrawer {
    public static void draw(List<Item> li)
    {
        int i=0;
        for (Item it:li) {
           // Log.d("INDEX", i+"");
           // Log.d("NAME", it.getTitle()+"");
            i++;
            it.draw();
        }
    }
}
