package com.example.user.startechtestapp.Parallax;

import android.graphics.Canvas;

public class ParallaxViewDrawer {
    public static double parallaxStrength = 0.1;
    public static void draw(Canvas cvs, ParallaxView PV, double[] tilt)
    {
        for (ParallaxLayer layer:PV.getLayers())
        {
            if(layer!=null) {
                ParallaxLayerDrawer.draw(cvs, layer, tilt);
            }
        }
    }
}
