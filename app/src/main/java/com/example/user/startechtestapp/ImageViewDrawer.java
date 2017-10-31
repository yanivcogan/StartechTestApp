package com.example.user.startechtestapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ImageViewDrawer {
    private List<ImageView> imageViews;
    private Canvas canvas;
    private Bitmap bitmap;
    private Paint paint;
    private int width, height;
    public ImageViewDrawer (ImageView iv, int width, int height)
    {
        this.width=width;
        this.height=height;
        this.imageViews = new ArrayList<>();
        this.addView(iv);
        this.bitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
        this.canvas = new Canvas(bitmap);
    }

    public void addView(ImageView iv)
    {
        this.imageViews.add(iv);
    }
    public void removeView (ImageView toRemove)
    {
            this.imageViews.remove(toRemove);
    }
    public void draw ()
    {
        RandomDotDrawer.drawRandDot(canvas);
        for (ImageView iv:imageViews) {
            iv.setImageBitmap(bitmap);
        }
    }
}
