package com.example.user.startechtestapp;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

class Previewer {
    private Item previewItem;
    private ImageView previewItemThumbnail;
    private TextView previewItemTitle;
    private TextView previewItemDescription;

    Previewer(Activity ctx)
    {
        previewItemTitle=(TextView) ctx.findViewById(R.id.previewItemTitle);
        previewItemDescription=(TextView) ctx.findViewById(R.id.previewItemDescription);
        previewItemThumbnail=(ImageView) ctx.findViewById(R.id.previewItemThumbnail);
    }
    void setPreviewItem(Item it)
    {
        unsetPreviewItem();
        this.previewItem=it;
        previewItemTitle.setText(previewItem.getTitle());
        previewItemDescription.setText(previewItem.getAuthorName());
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
