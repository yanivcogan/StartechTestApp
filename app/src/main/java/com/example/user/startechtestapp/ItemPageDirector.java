package com.example.user.startechtestapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by User on 15/10/2017.
 */

public class ItemPageDirector {
    public static void goToItemPage(Item item, Context origin)
    {
        Intent activityIntent = new Intent(origin, SecondaryActivity.class);
        Bundle aBundle = new Bundle();
        aBundle.putString("name",item.getTitle());
        aBundle.putString("imgurl",item.getImgURL());
        activityIntent.putExtra("itemData", aBundle);
        origin.startActivity(activityIntent);
    }
}
