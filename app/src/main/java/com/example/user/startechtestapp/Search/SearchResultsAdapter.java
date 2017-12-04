package com.example.user.startechtestapp.Search;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
    private final int LIST_TYPE=0;
    private final int GRID_TYPE=1;
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
       View root = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
       return new ViewHolder(root, previewer);
    }
    @Override public int getItemViewType(int position) {
        switch (itemLayout) {
            case LIST_TYPE:
                return R.layout.single_list_item;
            case GRID_TYPE:
                return R.layout.single_grid_item;
        }
        return super.getItemViewType(position);
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
            titleText = itemView.findViewById(R.id.itemTitle);
            urlText = itemView.findViewById(R.id.itemImgURL);
            thumbnail = itemView.findViewById(R.id.itemImage);
            detailsWrapper = itemView.findViewById(R.id.detailsBackground);
        }
        void bind(final Item item)
        {
            titleText.setText(item.getTitle());
            urlText.setText(item.getAuthorName());
            item.loadParallaxLayersImages(context);
            item.setImageView(thumbnail);
            thumbnail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(context.getResources().getBoolean(R.bool.bigScreen))
                    {
                        if(previewer!=null)
                        {
                            previewer.setPreviewItem(item);
                        }
                    }
                    else {
                        item.goToPage(context);
                    }
                }
            });
//ImageFetcher.loadImage(context, item.getImgURL(),thumbnail);
        }
    }
}

