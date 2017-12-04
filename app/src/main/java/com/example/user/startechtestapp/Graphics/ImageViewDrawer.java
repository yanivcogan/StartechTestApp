package com.example.user.startechtestapp.Graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

public class ImageViewDrawer {
    private ImageView imageView;
    private Bitmap bitmap;
    private Canvas canvas;

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public ImageViewDrawer(ImageView iv, int width, int height)
    {
        this.imageView=iv;
        this.bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.canvas = new Canvas(bitmap);
    }
    public void setView(ImageView iv)
    {
        imageView=iv;
    }
    public void updateViews()
    {
        imageView.setImageBitmap(bitmap);
    }
}
