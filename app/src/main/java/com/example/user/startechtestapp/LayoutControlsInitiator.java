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
        final Button toGrid = (Button) context.findViewById(R.id.layoutSwitchGrid);
        final Button toList = (Button) context.findViewById(R.id.layoutSwitchList);
        toGrid.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                toGrid.setVisibility(View.GONE);
                toList.setVisibility(View.VISIBLE);
            }
        });
        toList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                toList.setVisibility(View.GONE);
                toGrid.setVisibility(View.VISIBLE);
            }
        });
    }

}
