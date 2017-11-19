package com.example.user.startechtestapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class ItemPageDirector {
    static void goToItemPage(Item item, Context origin)
    {
        Intent activityIntent = new Intent(origin, SecondaryActivity.class);
        Bundle aBundle = new Bundle();
        aBundle.putString("name",item.getTitle());
        activityIntent.putExtra("itemData", aBundle);
        origin.startActivity(activityIntent);
    }
}
