package com.example.user.startechtestapp.SchemeRouting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SchemeRouter {
    Context context;
    private SchemeActivityMatcher schemeDictionary;
    private SchemeParser schemeParser;
    public SchemeRouter(Activity context)
    {
        this.context=context;
        schemeParser = new SchemeParser();
        schemeDictionary = new SchemeActivityMatcher();
    }
    public void route(String s)
    {
        Log.d("TEST","ROUTING_BEGINS for "+s);
        if(context!=null)
        {
            String activityKey = schemeParser.getActivityKey(s);
            Log.d("PARSED",activityKey);
            if (activityKey!=null) {
                Activity activity = schemeDictionary.getActivity(activityKey);
                if(activity!=null) {
                    Intent activityIntent = new Intent(context, activity.getClass());
                    context.startActivity(activityIntent);
                }
            }
        }
    }
}
