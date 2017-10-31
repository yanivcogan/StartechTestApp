package com.example.user.startechtestapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class ProductsListPopulator {
    public static void populate (List<Item> l, JSONArray arr)
    {
        try {
            for (int i = 0; i < arr.length(); i++) {
                JSONObject jsonItem = arr.getJSONObject(i);
                Item curr = new Item(jsonItem.getString("name"), jsonItem.getString("imageUrl"));
                l.add(curr);
            }
        }
        catch(JSONException e) {
        e.printStackTrace();
    }
    }
}
