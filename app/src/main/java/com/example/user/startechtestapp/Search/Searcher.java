package com.example.user.startechtestapp.Search;

import android.app.Activity;

import com.example.user.startechtestapp.History.HistoryRepository;

public class Searcher {
    private HistoryRepository historyRepository;
    Searcher(Activity context) {
        this.historyRepository = new HistoryRepository(context);
        this.historyRepository.fetchData();
    }
    public void search (String s)
    {
        historyRepository.addSearchTerm(s);
    }

    HistoryRepository getHistoryRepository() {
        return historyRepository;
    }

    public void setHistoryRepository(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }
}
