package com.example.projet;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.projet.adapter.DetailAdapter;
import java.util.ArrayList;
import java.util.List;

public class PageAnime extends AppCompatActivity {

    ImageView animeDetailImage;
    TextView animeDetailText;


    String aTitle,aImage,aId;

    DetailAdapter detailAdapter;
    RecyclerView detailRecycler;

    List<Type> typeList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pageanime);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Page anime
        animeDetailImage = findViewById(R.id.detail_image);
        animeDetailText = findViewById(R.id.detail_title);

        animeDetailText.setText(aTitle);
        Bundle bundle = getIntent().getExtras();
        int image = bundle.getInt("animeImage");
        animeDetailImage.setImageResource(image);


    //Main
        aTitle = getIntent().getStringExtra("animeName");
        aImage = getIntent().getStringExtra("animeImage");
        aId = getIntent().getStringExtra("animeId");







       // List<Saison> ListSaison1 = new ArrayList<>();
       // ListSaison1.add(new Saison(1,1,null,null));
       // ListSaison1.add(new Saison(2,2,null));
       // ListSaison1.add(new Saison(3,3,null));

        List<Saison> ListSaison2 = new ArrayList<>();
        ListSaison2.add(new Saison(1,"saison1",null,null));
        ListSaison2.add(new Saison(2,"Saison2",null,null));


       // List<Saison> ListSaison1 = new ArrayList<>();




        typeList = new ArrayList<>();
        typeList.add(new Type(1,"Anime",ListSaison2));
        typeList.add(new Type(2,"Scan",ListSaison2));

        setDetailRecycler(typeList);
    }

    public void setDetailRecycler(List<Type>typeList) {
        detailRecycler = findViewById(R.id.detail_anime_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        detailRecycler.setLayoutManager(layoutManager);
        detailAdapter = new DetailAdapter(this, typeList);
        detailRecycler.setAdapter(detailAdapter);
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