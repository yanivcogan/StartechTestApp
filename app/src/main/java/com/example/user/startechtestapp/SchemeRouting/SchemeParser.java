package com.example.user.startechtestapp.SchemeRouting;

public class SchemeParser {
    String getActivityKey(String url)
    {
        return url.substring(url.indexOf('/'), url.length()-1);
    }
}
