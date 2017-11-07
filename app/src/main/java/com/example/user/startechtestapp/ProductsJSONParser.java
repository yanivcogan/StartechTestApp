package com.example.user.startechtestapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 24/09/2017.
 */

public class ProductsJSONParser {
    static GsonBuilder builder = new GsonBuilder();
    static Gson gson = builder.create();
    public static List<Item> parse(String s)
    {
            try {
                JSONObject jsonObject=new JSONObject(s);
                JSONArray jsonArr = jsonObject.getJSONArray("products");
                List<Item> itemList = gson.fromJson(s, List<Item.class>);
return itemList;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
        }
    }
}
