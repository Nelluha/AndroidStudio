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

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ScanWebView extends AppCompatActivity {
    private WebView webView;
    String aTitle, aId, Nom;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_scan);
//affichage toolbar
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
//Recuparation des données


        aTitle = getIntent().getStringExtra("animeName");
        aId = getIntent().getStringExtra("animeId");


        webView = findViewById(R.id.webViewScan);
        webView.setWebViewClient(new WebViewClient());


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
            // Account for case: neither upper nor lower
            else {
                buf.append(c);
            }

        }

        String str = buf.toString();
        str = str.replaceAll("[!?;:)({}./@'=+*&]","");





        webView.loadUrl("https://www.japscan.lol/manga/" + str + "/");
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


