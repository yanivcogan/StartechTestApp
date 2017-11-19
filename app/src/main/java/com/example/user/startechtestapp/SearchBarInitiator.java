package com.example.user.startechtestapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;


class SearchBarInitiator {
    private EditText searchBar;
    private RecyclerView searchHistoryRV;
    private SearchHistoryAdapter searchHistoryAdapter;
    private Searcher searcher;

    void initiateSearchBar(final Activity context)
    {
        searcher=new Searcher(context);
        searchBar = (EditText) context.findViewById(R.id.searchBar);
        searchHistoryRV = (RecyclerView) context.findViewById(R.id.historyListContainer);
        searchBar.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    searchHistoryRV.setVisibility(View.VISIBLE);
                } else {
                    searchHistoryRV.setVisibility(View.GONE);
                    InputMethodManager imm =  (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null) {
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }

                }
            }
        });
        searchBar.setOnKeyListener(new View.OnKeyListener() {
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            // If the event is a key-down event on the "enter" button
            if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                    (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    search();
                    return true;
            }
            return false;
        }
    });

        searchHistoryRV = (RecyclerView) context.findViewById(R.id.historyListContainer);
        populateSearchHistoryAdapter(context);

        ImageButton searchButton = (ImageButton) context.findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            search();
            }
        });
    }
    private void search()
    {
        if(searcher!=null&&searchBar!=null) {
            String searchTerm = searchBar.getText().toString();
            searchBar.clearFocus();
            searcher.search(searchTerm);
        }
    }
    private void populateSearchHistoryAdapter(Activity context)
    {
        if (searchHistoryAdapter ==null)
        {
            searchHistoryAdapter = new SearchHistoryAdapter(searcher.getHistoryRepository().getHistory(), context, this.searcher);
            searchHistoryRV.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,false));
            searchHistoryRV.setAdapter(searchHistoryAdapter);
        }
        else
        {
            searchHistoryAdapter.setResults(searcher.getHistoryRepository().getHistory());
            searchHistoryAdapter.notifyDataSetChanged();
        }
    }
}
