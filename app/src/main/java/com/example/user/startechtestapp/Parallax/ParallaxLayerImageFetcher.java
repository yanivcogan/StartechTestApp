package com.example.user.startechtestapp.Parallax;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


class ParallaxLayerImageFetcher {
    static void loadImage(Context context, String url, final ParallaxLayer layer) {
        Resources res = context.getResources();
        int id = res.getIdentifier(url, "drawable",context.getPackageName());
        Bitmap image = BitmapFactory.decodeResource(res, id);
        layer.setImageBitmap(image);
    }
}