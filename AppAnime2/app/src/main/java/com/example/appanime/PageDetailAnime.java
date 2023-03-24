package com.example.appanime;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class PageDetailAnime extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Page anime
     /*   animeDetailImage = findViewById(R.id.detail_image);
        animeDetailText = findViewById(R.id.detail_title);

        animeDetailText.setText(aTitle);
        Bundle bundle = getIntent().getExtras();
        int image = bundle.getInt("animeImage");
        animeDetailImage.setImageResource(image);


        //Main
        aTitle = getIntent().getStringExtra("animeName");
        aImage = getIntent().getStringExtra("animeImage");

*/
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    public void clickMenu(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolbar_menu_profil:
                Intent otherActivity = new Intent(getApplicationContext(), PageProfil.class);
                startActivity(otherActivity);
                break;
        }
    }
}