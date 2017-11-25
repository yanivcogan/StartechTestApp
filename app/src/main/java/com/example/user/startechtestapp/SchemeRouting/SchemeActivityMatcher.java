package com.example.user.startechtestapp.SchemeRouting;

import android.app.Activity;
import android.util.Log;

import com.example.user.startechtestapp.SecondaryActivity;

import java.util.HashMap;
import java.util.Map;

class SchemeActivityMatcher {
    private Map<String, Activity> activityDictionary;
    SchemeActivityMatcher()
    {
        activityDictionary=new HashMap<>();
        activityDictionary.put("main", new SecondaryActivity());
    }
    Activity getActivity(String key)
    {
        Log.d("ACTIVTY", key);
        return activityDictionary.get(key);
    }
}
