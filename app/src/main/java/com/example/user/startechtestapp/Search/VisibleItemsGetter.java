package com.example.user.startechtestapp.Search;

import android.support.v7.widget.LinearLayoutManager;

import com.example.user.startechtestapp.ItemFunctions.Item;

import java.util.ArrayList;
import java.util.List;

public class VisibleItemsGetter {
    public static List<Item> getVisibleItems(LinearLayoutManager lm, List<Item> li)
    {
        List<Item> res = new ArrayList<>();
        int beg = lm.findFirstVisibleItemPosition();
        int end = lm.findLastVisibleItemPosition();
        for (int i=Math.max(0, beg); i<=end; i++) {
            res.add(li.get(i));
        }
        return res;
    }
}
