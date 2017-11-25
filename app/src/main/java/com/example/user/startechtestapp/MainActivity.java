package com.example.user.startechtestapp;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.user.startechtestapp.ItemFunctions.Item;
import com.example.user.startechtestapp.ItemFunctions.ItemsDrawer;
import com.example.user.startechtestapp.ItemFunctions.ItemsJSONParser;
import com.example.user.startechtestapp.SchemeRouting.SchemeRouter;
import com.example.user.startechtestapp.Search.Previewer;
import com.example.user.startechtestapp.Search.SearchBarInitiator;
import com.example.user.startechtestapp.Search.SearchResultsAdapter;
import com.example.user.startechtestapp.Search.VisibleItemsGetter;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static android.text.TextUtils.isEmpty;

public class MainActivity extends AppCompatActivity {
    Timer frameTimer;
    int framesPerSec = 8;
    int frameRate = 1000/framesPerSec;
    RecyclerView searchResultsRV;
    SearchResultsAdapter searchResultsAdapter;
    SearchBarInitiator searchBarInitiator;
    Context context;
    TXTReader txtReader;
    List<Item> results;
    Previewer itemPreviewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //check if opened using deeplinks, and if so route to the appropriate activity
        SchemeRouter router=new SchemeRouter(this);
        Uri data = this.getIntent().getData();
        if (data != null && data.isHierarchical()) {
            String uri = this.getIntent().getDataString();
            if(isEmpty(uri))
            {
                router.route(uri);
            }
        }
        //sets the layout that this code can reference
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        txtReader=new TXTReader(context);
        //fetch items list
        initializeResults();
        //construct
        buildUI();
        //start refresh timer to redraw thumbnails
        frameTimer = new Timer();
        frameTimer.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                frameListener();
            }
        },0,frameRate);
        //start listening for orientation changes to the device
        SensorsListener.InstantiateListener(context);
    }
    @Override
    protected void onResume ()
    {
        super.onResume();
        SensorsListener.start();
    }
    @Override
    protected void onPause ()
    {
        super.onPause();
        SensorsListener.stop();
    }
    private void initializeResults()
    {
        results = getData();
    }
    private List<Item> getData(){
        String booksJson = txtReader.loadFromAsset("books");
        return ItemsJSONParser.parse(booksJson);
    }
    private void buildUI()
    {
        searchBarInitiator=new SearchBarInitiator();
        searchBarInitiator.initiateSearchBar(this);
        searchResultsRV = (RecyclerView) findViewById(R.id.searchResultsListContainer);
        searchResultsAdapter = new SearchResultsAdapter(results, context, R.layout.single_grid_item, itemPreviewer);
        LayoutControlsInitiator layoutControlsInitiator = new LayoutControlsInitiator();
        layoutControlsInitiator.initiateLayoutControls(this, searchResultsRV, searchResultsAdapter);
        searchResultsRV.setAdapter(searchResultsAdapter);
        //create a preview view
        itemPreviewer = new Previewer(this);
    }

    void frameListener()
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                double [] tilt =SensorsListener.getTilt();
                ItemsDrawer.draw(VisibleItemsGetter.getVisibleItems((LinearLayoutManager)searchResultsRV.getLayoutManager(),results), tilt);
            }
        });
    }
}
