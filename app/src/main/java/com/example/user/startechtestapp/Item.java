package com.example.user.startechtestapp;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by User on 24/09/2017.
 */

public class Item {
    private static int canvasDisplayWidth = 500;
    private static int canvasDisplayHeight = 500;
    private String title;
    private String imgURL;
    private Boolean visibility;
    ImageViewDrawer canvasDisplay;

    public Item (String title, String imgURL)
    {
        this.title=title;
        this.imgURL=imgURL;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
    public void setImageView (ImageView iv)
    {
        if(canvasDisplay==null)
        {
            canvasDisplay=new ImageViewDrawer(iv, canvasDisplayWidth, canvasDisplayHeight);
        }
    }
    public ImageViewDrawer getImageView ()
    {
        return canvasDisplay;
    }
    public void draw()
    {
        if(canvasDisplay==null)
        {
            return;
        }
        else
        {
            canvasDisplay.draw();
        }
    }
    public void goToPage (Context origin)
    {
        ItemPageDirector.goToItemPage(this, origin);
    }
}
