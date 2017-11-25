package com.example.user.startechtestapp;

import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.user.startechtestapp.Search.SearchResultsAdapter;

class LayoutControlsInitiator {
    private Button toGrid, toList;
    private SearchResultsAdapter adapter;
    void initiateLayoutControls(final Activity context, final RecyclerView recycler, final SearchResultsAdapter adapter)
    {
        this.adapter = adapter;
        toGrid = context.findViewById(R.id.layoutSwitchGrid);
        toList = context.findViewById(R.id.layoutSwitchList);
        setLayoutToGrid(context,recycler);
        toGrid.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setLayoutToGrid(context, recycler);
            }
        });
        toList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setLayoutToList(context, recycler);
            }
        });
    }
    private void setLayoutToGrid(final Activity context, final RecyclerView recycler)
    {
        toGrid.setVisibility(View.GONE);
        toList.setVisibility(View.VISIBLE);
        adapter.setItemLayout(R.layout.single_grid_item);
        recycler.setLayoutManager(new GridLayoutManager(context, context.getResources().getInteger(R.integer.gridColCount)));
    }
    private void setLayoutToList(final Activity context, final RecyclerView recycler)
    {
        toList.setVisibility(View.GONE);
        toGrid.setVisibility(View.VISIBLE);
        adapter.setItemLayout(R.layout.single_list_item);
        recycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,false));
    }
}
