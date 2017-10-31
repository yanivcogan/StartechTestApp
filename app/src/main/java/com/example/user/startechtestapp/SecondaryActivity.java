package com.example.user.startechtestapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        Intent intent = getIntent();
        Bundle data = intent.getBundleExtra("itemData");
        String itemName = data.getString("name");
        final String itemURL = data.getString("imgurl");
        TextView title = (TextView) findViewById(R.id.titleText);
        title.setText(itemName);
        button = (Button) findViewById(R.id.buyButton);
        final Context context = getApplicationContext();
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityIntent = new Intent(context, ExternalWebView.class);
                Bundle aBundle = new Bundle();
                aBundle.putString("imgurl",itemURL);
                activityIntent.putExtra("purchaseData", aBundle);
                context.startActivity(activityIntent);
                button.setEnabled(false);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
       button.setEnabled(true);
    }
}
