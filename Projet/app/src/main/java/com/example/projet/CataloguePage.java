package com.example.projet;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CataloguePage extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_catalogue);
//affichage toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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

            case R.id.toolbar_menu_catalogue:
                Intent otherActivity1 = new Intent(getApplicationContext(), CataloguePage.class);
                startActivity(otherActivity1);
                break;

            case R.id.toolbar_menu_prochaine_sortie:
                Intent otherActivity2 = new Intent(getApplicationContext(), ProchaineSortiePage.class);
                startActivity(otherActivity2);
                break;

        }
    }
}
