package com.example.user.startechtestapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class SearchHistoryAdapter extends RecyclerView.Adapter <SearchHistoryAdapter.ViewHolder> {
    private List<String> data;
    private Searcher searcher;
    Context context;
    SearchHistoryAdapter(List<String> history, Context context, Searcher searcher)
    {
        this.data=history;
        this.context=context;
        this.searcher=searcher;
    }
    void setResults(List<String> history)
    {
        data=history;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_history_item, parent, false);
        return new ViewHolder(root);
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
        TextView suggestion;

        ViewHolder(View historyItemView)
        {
            super(historyItemView);
            suggestion = (TextView) historyItemView.findViewById(R.id.suggestionText);
        }
        void bind(final String historyItem)
        {
            suggestion.setText(historyItem);
            suggestion.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    searcher.search(historyItem);
                }
            });
        }
    }
}

