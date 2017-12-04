package com.example.user.startechtestapp.Search;

import android.app.Activity;

import com.example.user.startechtestapp.History.HistoryRepository;

public class Searcher {
    private HistoryRepository historyRepository;
    private SearchBarInitiator searchBarInitiator;
    public Searcher(Activity context) {
        this.historyRepository = new HistoryRepository(context);
        this.historyRepository.fetchData();
        this.searchBarInitiator = new SearchBarInitiator();
        searchBarInitiator.initiateSearchBar(context, this);
    }
    public void search (String s)
    {
        historyRepository.addSearchTerm(s);
        searchBarInitiator.clearSearchFocus();
        searchBarInitiator.setSearchText(s);
    }

    HistoryRepository getHistoryRepository() {
        return historyRepository;
    }

    public void setHistoryRepository(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }
}
