package com.example.user.startechtestapp;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by User on 29/10/2017.
 */

public class Previewer {
    Item previewItem;
    ImageView previewItemThumbnail;
    TextView previewItemTitle;
    TextView previewItemDescription;

    public Previewer (Activity ctx)
    {
        previewItemTitle=(TextView) ctx.findViewById(R.id.previewItemTitle);
        previewItemDescription=(TextView) ctx.findViewById(R.id.previewItemDescription);
        previewItemThumbnail=(ImageView) ctx.findViewById(R.id.previewItemThumbnail);
    }
    public void setPreviewItem (Item it)
    {
        unsetPreviewItem();
        this.previewItem=it;
        previewItemTitle.setText(previewItem.getTitle());
        previewItemDescription.setText(previewItem.getImgURL());
        it.getImageView().addView(previewItemThumbnail);
    }
    private void unsetPreviewItem()
    {
        if(this.previewItem!=null)
        {
            if(this.previewItem.getImageView()!=null)
            {
                this.previewItem.getImageView().removeView(previewItemThumbnail);
            }
        }
    }
}
