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
//Affichage  de la toolbar
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
//Recuparation des données
        aTitle = getIntent().getStringExtra("animeName");
        aId = getIntent().getStringExtra("animeId");

//Modification du titre pour acceder a la bonne page du site
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
            else {
                buf.append(c);
            }

        }

        String str = buf.toString();
        str = str.replaceAll("[!?;:)({}./@'=+*&]","");


        webView = findViewById(R.id.webViewAnime);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://anime-sama.fr/catalogue/" + str+ "/");
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