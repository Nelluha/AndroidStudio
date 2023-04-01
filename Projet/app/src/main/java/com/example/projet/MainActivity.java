package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projet.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Anime> animeList = new ArrayList<>();
    MainAdapter mainAdapter;
    RecyclerView mainRecycler;
    ImageView imageView;
    TextView textView;
    SearchView searchView;
    String URL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//affichage toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        URL = "https://api.jikan.moe/v4/anime";
        textView = findViewById(R.id.nom_item);
        imageView = findViewById(R.id.image_item);
        searchView = findViewById(R.id.searchbar);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });



        animeList.add(new Anime("1735", "naruto-shippuden", "https://1.bp.blogspot.com/-A5IKARiFIWk/XO5DGx2NTMI/AAAAAAAAQj0/sRS1liSORB4VBtJKWkxX_r_h3zqnsYFMQCLcBGAs/s2560/trunks-dragon-ball-super-hd-2048x2048.jpg", "Dans un futur proche suite à une mutation génétique, 80% de la population mondiale possède des super-pouvoirs appelés \" alters\"les super-héros protègent la population", "0"));
        animeList.add(new Anime("813", "dragon-ball-z", "https://th.bing.com/th/id/R.095580a9b2af07c03756a261a721cfb3?rik=lePs4s9ZjaCDIA&pid=ImgRaw&r=0", "Dans un futur proche suite à une mutation génétique, 80% de la population mondiale possède des super-pouvoirs appelés \" alters\"les super-héros protègent la population", "0"));
        animeList.add(new Anime("21", "one-piece", "https://1.bp.blogspot.com/-A5IKARiFIWk/XO5DGx2NTMI/AAAAAAAAQj0/sRS1liSORB4VBtJKWkxX_r_h3zqnsYFMQCLcBGAs/s2560/trunks-dragon-ball-super-hd-2048x2048.jpg", "Dans un futur proche suite à une mutation génétique, 80% de la population mondiale possède des super-pouvoirs appelés \" alters\"les super-héros protègent la population", "0"));
        animeList.add(new Anime("31964", "my-hero-academia", "https://1.bp.blogspot.com/-A5IKARiFIWk/XO5DGx2NTMI/AAAAAAAAQj0/sRS1liSORB4VBtJKWkxX_r_h3zqnsYFMQCLcBGAs/s2560/trunks-dragon-ball-super-hd-2048x2048.jpg", "Dans un futur proche suite à une mutation génétique, 80% de la population mondiale possède des super-pouvoirs appelés \" alters\"les super-héros protègent la population mondiale face aux super-vilains qui utilisent leur alter à des=\"\" fins=\"\" maléfiques.=\"\" le=\"\" plus=\"\" célèbre=\"\" super-héro=\"\" se=\"\" nomme=\"\" all=\"\" might.=\"\" izuku=\"\" midoriya=\"\" en=\"\" est=\"\" fan,=\"\" et=\"\" rêve=\"\" d'intégrer=\"\" filière=\"\" super-héroïque=\"\" du=\"\" lycée=\"\" yuei=\"\" pour=\"\" suivre=\"\" traces=\"\" de=\"\" son=\"\" idole=\"\" ainsi=\"\" devenir=\"\" grand=\"\" super-héros.=\"\" malheureusement,=\"\" ne=\"\" possède=\"\" pas=\"\" pouvoir.\"=\"\">", "0"));


        setMainRecycler((animeList));


    }


    private void filterList(String newText) {

        List<Anime> filteredList = new ArrayList<>();
        for(Anime anime : animeList){
            if(anime.getTitle().toLowerCase().contains(newText.toLowerCase())){
                filteredList.add(anime);
            }
        }
        if(filteredList.isEmpty()){
            Toast.makeText(this,"Aucun résultat pour cette recherche",Toast.LENGTH_LONG).show();
        }
        mainAdapter.setFilteredList(filteredList);


    }

    public void setMainRecycler(List<Anime> animeList) {
        mainRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mainRecycler.setLayoutManager(layoutManager);
        mainAdapter = new MainAdapter(this, animeList);
        mainRecycler.setAdapter(mainAdapter);


    }


    //Affichage du menu de la toolbar
    @Override
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

