package com.example.user.startechtestapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

class ItemsJSONParser {

    static List<Item> parse(String s)
    {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.excludeFieldsWithoutExposeAnnotation().create();
        Type itemListType = new TypeToken<ArrayList<Item>>(){}.getType();
        return gson.fromJson(s, itemListType);
    }
}
