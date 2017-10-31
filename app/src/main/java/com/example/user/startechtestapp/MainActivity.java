package com.example.user.startechtestapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ImageViewDrawer canvasDisplay;
    Timer frameTimer;
    int framesPerSec = 8;
    int frameRate = 1000/framesPerSec;
    RecyclerView rv;
    RecyclerView.LayoutManager layoutManager;
    SearchResultsAdapter myAdapter;
    Context context;
    TXTReader txtReader;
    List<Item> results;
    Previewer itemPreviewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sets the layout that this code can reference
        setContentView(R.layout.activity_main);
        //temp - number of items in a dynamically generated list
        final int MAX_RESULTS = 28;
        //defines the context for the app
        //LayoutControlsInitiator.initiateControls(this, );
        //the edit text object into which the user inputs their text
        context = getApplicationContext();
        txtReader=new TXTReader(context);
        itemPreviewer = new Previewer(this);
        buildUI();
        initializeResults();
/*
        //------parallax display------

        jsonReader=new JSONReader(context);
        Log.d("DEBUG", jsonReader.loadFromAsset("Moomintroll"));
        int canvasDisplayWidth = 500;
        int canvasDisplayHeight = 500;
        canvasDisplay=new ImageViewDrawer((ImageView) findViewById(R.id.mainImageView), canvasDisplayWidth, canvasDisplayHeight);
        */
        frameTimer = new Timer();
        frameTimer.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                frameListener();
            }
        },0,frameRate);
    }
    private void initializeResults()
    {
        results = getData();
        showResultsInListView();
    }
    private List<Item> getData(){
        List <Item> itemList = new ArrayList<>();
        ProductsListPopulator.populate(itemList,
                ProductsJSONParser.parse(txtReader.loadFromRaw("blah"))
        );
        return itemList;
    }
    private void buildUI()
    {
        rv = (RecyclerView) findViewById(R.id.rvListContainer);
    }
    public void showResultsInListView()
    {
        if (myAdapter==null)
        {
            myAdapter = new SearchResultsAdapter(results, getLayoutInflater(), context, itemPreviewer);
            layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false);
            rv.setLayoutManager(layoutManager);
            rv.setAdapter(myAdapter);
        }
        else
        {
            myAdapter.setResults(results);
            myAdapter.notifyDataSetChanged();
        }

    }
    public void showResultsInGridView()
    {
        if (myAdapter==null)
        {
            myAdapter = new SearchResultsAdapter(results, getLayoutInflater(), context, itemPreviewer);
            layoutManager = new GridLayoutManager(this, (int) getResources().getInteger(R.integer.gridColCount));
            rv.setLayoutManager(layoutManager);
            rv.setAdapter(myAdapter);
        }
        else
        {
            myAdapter.setResults(results);
            myAdapter.notifyDataSetChanged();
        }
    }
    void frameListener()
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ItemsDrawer.draw(VisibleItemsGetter.getVisibleItems((LinearLayoutManager)layoutManager,results));
            }
        });
    }
}
