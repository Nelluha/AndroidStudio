package com.example.utilisateur;

import static com.example.utilisateur.R.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;
import android.database.Cursor;


import android.view.View;
import android.widget.TextView;



import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import adapter.MainAdapter;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawerLayout;
    FloatingActionButton fab;
    public String name;
    ImageView refresh;

    List<Anime> animeList = new ArrayList<>();
    MainAdapter mainAdapter = new MainAdapter(this,animeList);


    DatabaseHelper d;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        // on affiche la toolbar

        Toolbar toolbar = findViewById(id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        drawerLayout = findViewById(id.drawer_layout);
        NavigationView navigationView = findViewById(id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, string.open_nav,
                string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(id.fragment_container, new Home()).commit();
            navigationView.setCheckedItem(id.nav_home);
        }

        //Ici on recupere l'email de la connexion

        View header = navigationView.getHeaderView(0);

        TextView navName = (TextView) header.findViewById(R.id.navName);


        Bundle bundle = getIntent().getExtras();
        String email=bundle.getString("email");
        navName.setText(email);


        refresh = findViewById(R.id.refreshView);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otheractivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otheractivity);
            }
        });
        checkAirplaneMode();



    }
    private void checkAirplaneMode() {
        if (isAirplaneModeOn(getApplicationContext())) {
            Intent otherActivity = new Intent(getApplicationContext(), flightMode.class);
            startActivity(otherActivity);

        }
    }

    private static boolean isAirplaneModeOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }


// la navigation chaque fragmentss que contient le menu
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(id.fragment_container, new Home()).commit();
                break;
            case id.nav_setting:
                getSupportFragmentManager().beginTransaction().replace(id.fragment_container, new settingFragment()).commit();
                break;
            case id.nav_info:
                getSupportFragmentManager().beginTransaction().replace(id.fragment_container, new aboutFragment()).commit();
                break;
            case id.nav_exit:
                Intent otheractivity = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(otheractivity);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }



    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}