package com.example.utilisateur;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AnimeWebView extends AppCompatActivity {
    private WebView webView;
    String aTitle, aId;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_anime);
//affichage toolbar
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        aTitle = getIntent().getStringExtra("animeName");
        aId = getIntent().getStringExtra("animeId");

        String titre =  aTitle.replace(" ","-");

        StringBuilder buf = new StringBuilder(titre.length());
        for (int i = 0; i < titre.length(); i++) {
            char c = titre.charAt(i);

            if (Character.isUpperCase(c)|| Character.isLowerCase(c)) {
                buf.append(Character.toLowerCase(c));

            }
            else if (Character.isWhitespace(c)) {
                buf.append("-");

            }
            // Account for case: neither upper nor lower
            else {
                buf.append(c);
            }

        }




        webView = findViewById(R.id.webViewAnime);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://anime-sama.fr/catalogue/" + buf.toString()+ "/");
        Toast.makeText(getApplicationContext(),buf.toString(),Toast.LENGTH_SHORT).show();
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }

    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();

        }
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.refreshView:
                Intent otherActivity2 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(otherActivity2);
        }
    }





}