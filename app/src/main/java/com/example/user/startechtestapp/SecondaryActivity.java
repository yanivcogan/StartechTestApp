package com.example.user.startechtestapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.startechtestapp.ItemFunctions.Item;
import com.example.user.startechtestapp.ItemFunctions.ItemsDrawer;

import java.util.Timer;
import java.util.TimerTask;

public class SecondaryActivity extends AppCompatActivity {
    Button button;
    Item displayedItem;
    ItemsDrawer itemsDrawer;
    SensorsListener sensorsListener;
    Timer frameTimer;
    int framesPerSec = 30;
    int frameRate = 1000/framesPerSec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        Intent intent = getIntent();
        displayedItem = (Item)intent.getSerializableExtra("item");
        //setup service
        //setup items drawer
        itemsDrawer = new ItemsDrawer();
        //setup sensors listener
        sensorsListener = new SensorsListener();
        sensorsListener.InstantiateListener(this);
        //make UI display the data about the passed item
        displayItem();
        //startup thumbnail draw refresh rate
        frameTimer = new Timer();
        frameTimer.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                frameListener();
            }
        },0,frameRate);
    }
private void displayItem()
{
    //get the activity context, used for generating intents
    final Context context = getApplicationContext();
    //display the item title
    TextView title = (TextView) findViewById(R.id.titleText);
    title.setText(displayedItem.getTitle());
    //display the item author
    TextView author = (TextView) findViewById(R.id.descriptionText);
    author.setText(displayedItem.getAuthorName());
    //set up parallax view canvas
    ImageView image = findViewById(R.id.itemImage);
    displayedItem.setImageView(image);
    //set up parallax thumbnail content
    displayedItem.loadParallaxLayersImages(context);
    //bind button to opening up the appropriate page on click
    button = (Button) findViewById(R.id.buyButton);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent activityIntent = new Intent(context, ExternalWebView.class);
            Bundle aBundle = new Bundle();
            aBundle.putString("url",displayedItem.getGoodreadsLink());
            activityIntent.putExtra("purchaseData", aBundle);
            context.startActivity(activityIntent);
            button.setEnabled(false);
        }
    });
}
    void frameListener()
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                double [] tilt =sensorsListener.getTilt();
                itemsDrawer.drawItem(displayedItem, tilt);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        button.setEnabled(true);
        sensorsListener.start();
    }
    @Override
    protected void onPause ()
    {
        super.onPause();
        sensorsListener.stop();
    }
}
