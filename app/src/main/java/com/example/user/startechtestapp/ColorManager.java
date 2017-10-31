package com.example.user.startechtestapp;

import android.graphics.Color;

/**
 * Created by User on 17/09/2017.
 */

public class ColorManager {
    public static int getRandomColor()
    {
        return ColorManager.getWeightedRandomColor(new double[]{1.0,1.0,1.0});
    }
    public static int getWeightedRandomColor(double[]weight)
    {
        if(weight.length!=3)
        {
            return Color.BLACK;
        }
        else
        {
            int red =(int)(Math.random()*255/weight[0]);
            int green =(int)(Math.random()*255/weight[0]);
            int blue = (int)(Math.random()*255/weight[0]);
            return Color.rgb(red, green, blue);
        }
    }
}
