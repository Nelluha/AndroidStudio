package com.example.utilisateur;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;



public class
PageAnime extends AppCompatActivity {

    ImageView animeDetailImage;
    TextView animeDetailText, animeDetailSynopsis;
    Button btnA, btnS;
    Context context;

    String aTitle, aImage, aSynopsis,aId;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_detail);


        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Page anime
        animeDetailImage = findViewById(R.id.imageView);
        animeDetailText = findViewById(R.id.nom_page_detail);
        animeDetailSynopsis = findViewById(R.id.texteResume);
        btnA = findViewById(R.id.btnAnime);
        btnS = findViewById(R.id.btnScan);




        //Affichage des informations sur la page anime en fonction de manga selectionné
        aTitle = getIntent().getStringExtra("animeName");
        aSynopsis = getIntent().getStringExtra("animeSynopsis");
        aImage = getIntent().getStringExtra("animeImage");
        aId = getIntent().getStringExtra("animeId");

        animeDetailText.setText(aTitle);
        animeDetailSynopsis.setText(aSynopsis);


        Glide
                .with(this)
                .load(aImage)
                .into(animeDetailImage);



    }

//Redirection a partir de boutons sur les webView ou vers la home page
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAnime:
                Intent otherActivity = new Intent(getApplicationContext(), AnimeWebView.class);
                otherActivity.putExtra("animeName", aTitle);
                otherActivity.putExtra("animeId", aId);
                startActivity(otherActivity);
                break;

            case R.id.btnScan:
                Intent otherActivity1 = new Intent(getApplicationContext(), ScanWebView.class);
                otherActivity1.putExtra("animeName", aTitle);
                otherActivity1.putExtra("animeId", aId);
                startActivity(otherActivity1);
                break;

            case R.id.refreshView:
                Intent otherActivity2 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(otherActivity2);
        }
    }
}