package com.example.user.startechtestapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import org.json.JSONObject;

public class ParallaxViewDrawer {
    private static double parallaxStrength = 10.0;
    private static Paint p = new Paint();
    public static void draw(Canvas cvs, ParallaxView PV, int globX, int globY, double tilt)
    {

    }
    public static void drawLayer (Canvas cvs, Bitmap img, int x, int y, double depth, double tiltX, double tiltY, int globX, int globY)
    {
        Point pos = ParallaxViewDrawer.calcLayerOrigin(x, y, globX, globY, depth, tiltX, tiltY);
        cvs.drawBitmap(img, pos.x, pos.y, p);
    }
    public static void drawLayer (Canvas cvs, Bitmap img, int x, int y, double depth, double tiltX, double tiltY)
    {
        ParallaxViewDrawer.drawLayer(cvs, img, x, y, depth, tiltX, tiltY, 0, 0);
    }
    public static Point calcLayerOrigin (int x, int y, int globX, int globY, double depth, double tiltX, double tiltY)
    {
        int trueX = (int)(x+globX+(ParallaxViewDrawer.parallaxStrength*depth*tiltX));
        int trueY = (int)(y+globY+(ParallaxViewDrawer.parallaxStrength*depth*tiltY));
        Point point = new Point(trueX, trueY);
        return point;
    }
}
