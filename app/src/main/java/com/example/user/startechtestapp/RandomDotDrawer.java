package com.example.user.startechtestapp;

import android.graphics.Canvas;
import android.graphics.Paint;

public class RandomDotDrawer {
    private static Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private static int dotRadius = 30;
    public static void drawRandDot(Canvas cvs)
    {
        int randomColor = ColorManager.getRandomColor();
        int x = (int)(Math.random()*cvs.getWidth());
        int y = (int)(Math.random()*cvs.getWidth());
        RandomDotDrawer.paint.setColor(randomColor);
        cvs.drawCircle(x, y, RandomDotDrawer.dotRadius, paint);
    }
}
