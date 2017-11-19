package com.example.user.startechtestapp;

import android.app.Activity;

public class Searcher {
    private HistoryRepository historyRepository;
    Searcher(Activity context) {
        this.historyRepository = new HistoryRepository(context);
        this.historyRepository.fetchData();
    }
    void search (String s)
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
