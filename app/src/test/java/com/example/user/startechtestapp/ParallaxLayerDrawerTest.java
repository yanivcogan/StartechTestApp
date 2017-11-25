package com.example.user.startechtestapp;

import android.graphics.Point;

import com.example.user.startechtestapp.Parallax.ParallaxLayerDrawer;
import com.example.user.startechtestapp.Parallax.ParallaxViewDrawer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ParallaxLayerDrawerTest {
    @Test
        public void calcLayerOriginReturnsCorrectOrigin() throws Exception {
        int frameWidth=500;
        int frameHeight=500;
        int layerWidth=200;
        int layerHeight=200;
        double offsetX=0;
        double offsetY=0;
        double parallaxFactorX=1;
        double parallaxFactorY=1;
        double tiltX=1;
        double tiltY=0;
        Point origin = ParallaxLayerDrawer.calcLayerOrigin(frameWidth,frameHeight,layerWidth,layerHeight,offsetX,offsetY,parallaxFactorX,parallaxFactorY,tiltX,tiltY);
        int result = (int)(250+ ParallaxViewDrawer.parallaxStrength*frameWidth);
        assertEquals(origin.y, result);
    }
}