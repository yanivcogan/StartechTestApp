package com.example.user.startechtestapp.Parallax;

import android.content.Context;
import android.graphics.Bitmap;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ParallaxLayer implements Serializable{
    @Expose @SerializedName("name")private String name;
    @Expose @SerializedName("image_path")private String path;
    transient private Bitmap layerImg;
    @Expose @SerializedName("center_offset_x")private double centerOffsetX;
    @Expose @SerializedName("center_offset_y")private double centerOffsetY;
    @Expose @SerializedName("parallax_factor_x")private double parallaxFactorX;
    @Expose @SerializedName("parallax_factor_y")private double parallaxFactorY;
    @Expose @SerializedName("size_factor_y")private double sizeFactorY=1;
    @Expose @SerializedName("size_factor_x")private double sizeFactorX=1;


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
double getSizeFactorY()
{
    return sizeFactorY;
}
double getSizeFactorX()
{
    return sizeFactorX;
}
    void loadImage(Context context, boolean reloadIfExists)
    {
        if(reloadIfExists||layerImg==null)
        {
            ParallaxLayerImageFetcher.loadImage(context, path, this, sizeFactorX, sizeFactorY);
        }
    }
    void setImageBitmap(Bitmap img)
    {
        layerImg=img;
    }
}
