package com.example.user.startechtestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ExternalWebView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_web_view);
        Intent targetIntent = getIntent();
        Bundle purchaseData = targetIntent.getBundleExtra("purchaseData");
        String url = purchaseData.getString("imgurl");
        WebView webview = (WebView)findViewById(R.id.mainWebFrame);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl(url);
    }
}
