package com.example.user.startechtestapp;

import android.graphics.Canvas;

class ParallaxViewDrawer {
    static double parallaxStrength = 0.1;
    static void draw(Canvas cvs, ParallaxView PV, double[] tilt)
    {
        for (ParallaxLayer layer:PV.getLayers())
        {
            ParallaxLayerDrawer.draw(cvs, layer, tilt);
        }
    }
}
