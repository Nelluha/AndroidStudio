package com.example.utilisateur;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class flightMode extends AppCompatActivity {

    ImageView refresh;
    Context context;
    TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flightmode);

        textView = findViewById(R.id.TextFlightMode);

        /*Cette page s'affiche tant que le mode avion est activé.
        En appuyant sur le bouton refresh on est redirigé vers la page home*/

        refresh = findViewById(R.id.refreshView);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otheractivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(otheractivity);
            }
        });



    }
    }

