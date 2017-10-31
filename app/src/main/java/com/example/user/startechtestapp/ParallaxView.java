package com.example.user.startechtestapp;

import org.json.JSONObject;

public class ParallaxView {

    JSONObject layers;
    public ParallaxView (JSONObject layers)
    {
        this.layers=layers;
    }
    public JSONObject getLayers() {
        return layers;
    }

    public void setLayers(JSONObject layers) {
        this.layers = layers;
    }
}
