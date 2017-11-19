package com.example.user.startechtestapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

public class ImageViewDrawer {
    private List<ImageView> imageViews;

    Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    private Canvas canvas;
    private Bitmap bitmap;
    ImageViewDrawer(ImageView iv, int width, int height)
    {
        this.imageViews = new ArrayList<>();
        this.addView(iv);
        this.bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.canvas = new Canvas(bitmap);
    }

    void addView(ImageView iv)
    {
        this.imageViews.add(iv);
    }
    void removeView(ImageView toRemove)
    {
            this.imageViews.remove(toRemove);
    }
    void updateViews()
    {
        for (ImageView iv:imageViews) {
            iv.setImageBitmap(bitmap);
        }
    }
}
