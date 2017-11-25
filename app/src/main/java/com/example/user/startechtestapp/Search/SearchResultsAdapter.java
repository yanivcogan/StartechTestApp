package com.example.user.startechtestapp.Search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.startechtestapp.ItemFunctions.Item;
import com.example.user.startechtestapp.R;

import java.util.List;

public class SearchResultsAdapter extends RecyclerView.Adapter <SearchResultsAdapter.ViewHolder> {
    private List<Item> data;
    Context context;
    private Previewer previewer;
    private int itemLayout;
    public SearchResultsAdapter(List<Item> results, Context context, int itemLayout, Previewer previewer)
    {
        this.data=results;
        this.context=context;
        this.previewer = previewer;
        this.itemLayout = itemLayout;
    }
    public void setResults (List<Item> results)
    {
        data=results;
    }
    public void setItemLayout(int itemLayout) {
        this.itemLayout = itemLayout;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
       View root = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
       return new ViewHolder(root, previewer);
    }
    @Override
    public void onBindViewHolder (ViewHolder holder, int pos)
    {
        holder.bind(data.get(pos));
    }
    @Override
    public int getItemCount ()
    {
        return data==null?0:data.size();
    }
    @Override
    public long getItemId (int pos)
    {
        return pos;
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView titleText;
        TextView urlText;
        LinearLayout detailsWrapper;
        ImageView thumbnail;
        Previewer previewer;

        ViewHolder(View itemView, Previewer previewer)
        {
            super(itemView);
            this.previewer=previewer;
            titleText = (TextView) itemView.findViewById(R.id.itemTitle);
            urlText = (TextView) itemView.findViewById(R.id.itemImgURL);
            thumbnail = (ImageView) itemView.findViewById(R.id.itemImage);
            detailsWrapper = (LinearLayout) itemView.findViewById(R.id.detailsBackground);
        }
        void bind(final Item item)
        {
            titleText.setText(item.getTitle());
            urlText.setText(item.getAuthorName());
            item.loadParallaxLayersImages(context);
            item.setImageView(thumbnail);
            thumbnail.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent e) {
                    switch (e.getAction()) {
                        case MotionEvent.ACTION_UP:
                        if (context.getResources().getBoolean(R.bool.bigScreen)) {
                            // context.previewItem();
                            if (previewer != null) {
                                previewer.setPreviewItem(item);
                            }
                        } else {
                            item.goToPage(context);
                        }
                        break;
                    }
                    return true;
                }
            });
            thumbnail.setOnHoverListener(new View.OnHoverListener() {
                @Override
                public boolean onHover(View view, MotionEvent e) {
                    Log.d("ACTION",""+e.getAction());
                    switch (e.getAction()) {
                        case MotionEvent.ACTION_HOVER_MOVE:
                        case MotionEvent.ACTION_HOVER_ENTER:
                            detailsWrapper.setVisibility(View.VISIBLE);
                            break;
                        case MotionEvent.ACTION_HOVER_EXIT:
                            detailsWrapper.setVisibility(View.GONE);
                            break;
                    }
                    return true;
                }
            });
            //ImageFetcher.loadImage(context, item.getImgURL(),thumbnail);
        }
    }
}

