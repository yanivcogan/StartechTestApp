package com.example.user.startechtestapp.Parallax;


import android.content.Context;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ParallaxView {
    @Expose @SerializedName("layers")
    private List<ParallaxLayer> layers;

    public ParallaxView (List<ParallaxLayer> layers)
    {
        this.layers=layers;
    }

    List<ParallaxLayer> getLayers() {
        return layers;
    }

    public void setLayers(List<ParallaxLayer> layers) {
        this.layers = layers;
    }

    private void loadLayerImages(Context context, boolean reloadIfExists)
    {
        for (ParallaxLayer layer : layers)
        {
            layer.loadImage(context, reloadIfExists);
        }
    }

    public void loadLayerImages(Context context)
    {
        this.loadLayerImages(context, false);
    }
}
