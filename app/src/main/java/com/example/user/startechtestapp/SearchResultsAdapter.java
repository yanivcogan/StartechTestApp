package com.example.user.startechtestapp;

import android.content.Context;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SearchResultsAdapter extends RecyclerView.Adapter <SearchResultsAdapter.ViewHolder> {
    List<Item> data;
    LayoutInflater inflater;
    Context context;
    Previewer previewer;
    public SearchResultsAdapter(List<Item> results, LayoutInflater inflater, Context context, Previewer previewer)
    {
        this.data=results;
        this.inflater=inflater;
        this.context=context;
        this.previewer = previewer;
    }
    public void setResults (List<Item> results)
    {
        data=results;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
       View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_grid_item, parent, false);
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

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView titleText;
        TextView urlText;
        ImageView thumbnail;
        Previewer previewer;

        public ViewHolder(View itemView, Previewer previewer)
        {
            super(itemView);
            this.previewer=previewer;
            titleText = (TextView) itemView.findViewById(R.id.itemTitle);
            urlText = (TextView) itemView.findViewById(R.id.itemImgURL);
            thumbnail = (ImageView) itemView.findViewById(R.id.itemImage);
        }
        public void bind (final Item item)
        {
            titleText.setText(item.getTitle());
            urlText.setText(item.getImgURL());
            item.setImageView(thumbnail);
            thumbnail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if((boolean)context.getResources().getBoolean(R.bool.bigScreen))
                    {
                       // context.previewItem();
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

