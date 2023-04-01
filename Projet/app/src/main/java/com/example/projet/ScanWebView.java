package com.example.projet;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ScanWebView extends AppCompatActivity {
    private WebView webView;
    String aTitle, aId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_scan);
//affichage toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        aTitle = getIntent().getStringExtra("animeName");
        aId = getIntent().getStringExtra("animeId");


        webView = findViewById(R.id.webViewScan);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.japscan.lol/manga/" + aTitle + "/");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        Toast.makeText(this, aTitle, Toast.LENGTH_SHORT).show();

    }

    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();

        }
    }

    }


