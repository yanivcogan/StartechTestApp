package com.example.user.startechtestapp.Parallax;

import android.content.Context;
import android.graphics.Bitmap;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParallaxLayer {
    @Expose @SerializedName("name")private String name;
    @Expose @SerializedName("image_path")private String path;
    private Bitmap layerImg;
    @Expose @SerializedName("center_offset_x")private double centerOffsetX;
    @Expose @SerializedName("center_offset_y")private double centerOffsetY;
    @Expose @SerializedName("parallax_factor_x")private double parallaxFactorX;
    @Expose @SerializedName("parallax_factor_y")private double parallaxFactorY;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    Bitmap getLayerImg() {
        return layerImg;
    }

    public void setLayerImg(Bitmap layerImg) {
        this.layerImg = layerImg;
    }

    double getCenterOffsetX() {
        return centerOffsetX;
    }

    public void setCenterOffsetX(int centerOffsetX) {
        this.centerOffsetX = centerOffsetX;
    }

    double getCenterOffsetY() {
        return centerOffsetY;
    }

    public void setCenterOffsetY(int centerOffsetY) {
        this.centerOffsetY = centerOffsetY;
    }

    double getParallaxFactorX() {
        return parallaxFactorX;
    }

    public void setParallaxFactorX(double parallaxFactorX) {
        this.parallaxFactorX = parallaxFactorX;
    }

    double getParallaxFactorY() {
        return parallaxFactorY;
    }

    public void setParallaxFactorY(double parallaxFactorY) {
        this.parallaxFactorY = parallaxFactorY;
    }

    void loadImage(Context context, boolean reloadIfExists)
    {
        if(reloadIfExists||layerImg==null)
        {
            ParallaxLayerImageFetcher.loadImage(context, path, this);
        }
    }
    void setImageBitmap(Bitmap img)
    {
        layerImg=img;
    }
}
