package com.example.user.startechtestapp.Parallax;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


class ParallaxLayerImageFetcher {
    static void loadImage(Context context, String url, final ParallaxLayer layer, double sizeFactorX, double sizeFactorY) {
        Resources res = context.getResources();
        int id = res.getIdentifier(url, "drawable",context.getPackageName());
        Bitmap image = BitmapFactory.decodeResource(res, id);
        Bitmap scaledBitmap =Bitmap.createScaledBitmap(image, (int)(image.getWidth()*sizeFactorX), (int)(image.getHeight()*sizeFactorY), true);
        layer.setImageBitmap(scaledBitmap);
    }
}