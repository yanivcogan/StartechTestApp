package com.example.user.startechtestapp;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class TXTReader {
    private Context context;
    private AssetManager assetManager;

    TXTReader(Context ctx)
    {
        this.context=ctx;
        assetManager = this.context.getAssets();
    }

    String loadFromAsset(String filename) {
        if (this.context==null)
        {
            return null;
        }
        StringBuilder json = new StringBuilder();
        try {
            InputStream is =  assetManager.open(filename+".txt");
            BufferedReader in= new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String str ="";
            while ((str=in.readLine()) != null) {
                json.append(str);
            }
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json.toString();
    }
}
