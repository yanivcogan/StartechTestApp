package com.example.user.startechtestapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

class LayoutControlsInitiator {
    @SuppressLint("StaticFieldLeak")
    private static Button toGrid, toList;
    static void initiateControls(final Activity context, final RecyclerView recycler)
    {
        toGrid = (Button) context.findViewById(R.id.layoutSwitchGrid);
        toList = (Button) context.findViewById(R.id.layoutSwitchList);
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
    private static void setLayoutToGrid(final Activity context, final RecyclerView recycler)
    {
        toGrid.setVisibility(View.GONE);
        toList.setVisibility(View.VISIBLE);
        recycler.setLayoutManager(new GridLayoutManager(context, context.getResources().getInteger(R.integer.gridColCount)));
    }
    private static void setLayoutToList(final Activity context, final RecyclerView recycler)
    {
        toList.setVisibility(View.GONE);
        toGrid.setVisibility(View.VISIBLE);
        recycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,false));
    }
}
