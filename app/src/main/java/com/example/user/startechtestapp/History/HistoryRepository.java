package com.example.user.startechtestapp.History;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static android.text.TextUtils.isEmpty;

public class HistoryRepository {
    private List<String> history=new ArrayList<>();
    private SharedPreferences preferences;
    private Gson gson;
    public HistoryRepository(Activity context)
    {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        gson = new Gson();
    }
    public void fetchData()
    {
        String historyJSON = preferences.getString("History", "");
        Type stringListType = new TypeToken<ArrayList<String>>(){}.getType();
        history=gson.fromJson(historyJSON,stringListType);
        if(history==null)
            history=new ArrayList<>();
    }
    public List<String> getHistory()
    {
        return history;
    }
    public void addSearchTerm(String search)
    {
        if(!isEmpty(search)&&history.indexOf(search)==-1) {
            history.add(search);
            updateLocalStorage();
        }
    }
    private void updateLocalStorage()
    {
        SharedPreferences.Editor editor = preferences.edit();
        String historyJSON = gson.toJson(history);
        editor.putString("History",historyJSON);
        editor.apply();
    }
    public void clearHistory()
    {
        //TODO
    }
}
