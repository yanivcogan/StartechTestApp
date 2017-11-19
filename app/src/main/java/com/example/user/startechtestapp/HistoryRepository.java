package com.example.user.startechtestapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HistoryRepository {
    private List<String> history=new ArrayList<>();
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Gson gson;
    @SuppressLint("CommitPrefEdits")
    HistoryRepository(Activity context)
    {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        gson = new Gson();
    }
    void fetchData()
    {
        String historyJSON = preferences.getString("History", "");
        Type stringListType = new TypeToken<ArrayList<String>>(){}.getType();
        history=gson.fromJson(historyJSON,stringListType);
        if(history==null)
            history=new ArrayList<>();
    }
    List<String> getHistory()
    {
        return history;
    }
    void addSearchTerm(String search)
    {
        if(!search.equals("")&&history.indexOf(search)==-1) {
            history.add(search);
            updateLocalStorage();
        }
    }
    private void updateLocalStorage()
    {
        String historyJSON = gson.toJson(history);
        editor.putString("History",historyJSON);
        editor.apply();
    }
    public void clearHistory()
    {
        //TODO
    }
}
