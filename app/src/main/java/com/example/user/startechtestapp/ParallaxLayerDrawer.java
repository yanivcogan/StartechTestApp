package com.example.user.startechtestapp;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

class ParallaxLayerDrawer {
    private static Paint p = new Paint();

    static void draw(Canvas cvs, ParallaxLayer l, double[] tilt)
    {
        if(l.getLayerImg()!=null) {
            Point origin = calcLayerOrigin(cvs.getWidth(), cvs.getHeight(), l.getLayerImg().getWidth(), l.getLayerImg().getHeight(), l.getCenterOffsetX(), l.getCenterOffsetY(), l.getParallaxFactorX(), l.getParallaxFactorY(), tilt[2], tilt[0]);
            cvs.drawBitmap(l.getLayerImg(), origin.x, origin.y, p);
        }
    }

    static Point calcLayerOrigin(int frameWidth, int frameHeight, int layerWidth, int layerHeight, double offsetX, double offsetY, double parallaxFactorX, double parallaxFactorY, double tiltX, double tiltY)
    {
        int maxPixelOffsetX = (int)(ParallaxViewDrawer.parallaxStrength*frameWidth);
        int maxPixelOffsetY = (int)(ParallaxViewDrawer.parallaxStrength*frameHeight);
        int x = ((frameWidth-layerWidth)/2);
        x+=(int)(offsetX*frameWidth);
        x+=(int)(maxPixelOffsetX*parallaxFactorX*tiltX);
        //Log.d("parallaxFactorX", ""+parallaxFactorX);
        //Log.d("TESTING", ""+(int)(maxPixelOffsetX*parallaxFactorX*tiltX));
        int y = (frameHeight-layerHeight)/2;
        y+=(int)(offsetY*frameHeight);
        y+= (int)(maxPixelOffsetY*parallaxFactorY*tiltY);
        return new Point(x,y);
    }
}
