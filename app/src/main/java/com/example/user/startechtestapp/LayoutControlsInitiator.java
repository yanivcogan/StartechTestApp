package com.example.user.startechtestapp;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

/**
 * Created by User on 22/10/2017.
 */

public class LayoutControlsInitiator {
    public static void initiateControls (final Activity context, final SearchResultsAdapter adapter)
    {
        Button toGrid = (Button) context.findViewById(R.id.layoutSwitchGrid);
        toGrid.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("CLICK", "grid");

            }
        });
        Button toList = (Button) context.findViewById(R.id.layoutSwitchList);
        toList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("CLICK", "list");
            }
        });
    }

}
