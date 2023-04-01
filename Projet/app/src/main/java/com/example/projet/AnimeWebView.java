package com.example.projet;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        aTitle = getIntent().getStringExtra("animeName");
        aId = getIntent().getStringExtra("animeId");


        webView = findViewById(R.id.webViewAnime);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://anime-sama.fr/catalogue/" + aTitle + "/");
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

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    public void clickMenu(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolbar_menu_profil:
                Intent otherActivity = new Intent(getApplicationContext(), ProfilPage.class);
                startActivity(otherActivity);
                break;

        }
    }
}