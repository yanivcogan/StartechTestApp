package com.example.user.startechtestapp;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;

public class TXTReader {
    private Context context;
    private AssetManager assetManager;

    public TXTReader (Context ctx)
    {
        this.context=ctx;
        assetManager = this.context.getAssets();
    }
    public String loadFromRaw (String filename)
    {
        try {
            InputStream is = context.getResources().openRawResource(R.raw.search);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String str = new String(buffer, "UTF-8");
            return str;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }
    public String loadFromAsset(String filename) {
        if (this.context==null)
        {
            return null;
        }
        String json = null;
        try {
            InputStream is =  assetManager.open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
