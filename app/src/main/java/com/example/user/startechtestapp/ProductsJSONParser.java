package com.example.user.startechtestapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 24/09/2017.
 */

public class ProductsJSONParser {
    public static JSONArray parse(String s)
    {
            try {
                JSONObject jsonObject=new JSONObject(s);
                JSONArray jsonArr = jsonObject.getJSONArray("products");
                return jsonArr;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
        }
    }
}
