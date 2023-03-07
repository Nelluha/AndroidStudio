package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.projet.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CardView homePageNouveautes;
    private CardView homePageDiscover;
    private CardView homePageClassique;
    private CardView homePageDay;
    List<Category> categoryList;

    MainAdapter mainAdapter;
    RecyclerView mainRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//affichage toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        List<CategoryItem> homeCateListItem1 = new ArrayList<>();
        homeCateListItem1.add(new CategoryItem(1, "Naruto", R.drawable.gaara, null));
        homeCateListItem1.add(new CategoryItem(2, "Dragon Ball z", R.drawable.dbz, null));
        homeCateListItem1.add(new CategoryItem(3, "One Piece", R.drawable.sasuke, null));
        homeCateListItem1.add(new CategoryItem(4, "My Hero Academia", R.drawable.pain, null));

        List<CategoryItem> homeCateListItem2 = new ArrayList<>();
        homeCateListItem2.add(new CategoryItem(5, "Dragon Ball z", R.drawable.dbz, null));
        homeCateListItem2.add(new CategoryItem(6, "Naruto", R.drawable.gaara, null));
        homeCateListItem2.add(new CategoryItem(7, "One Piece", R.drawable.sasuke, null));
        homeCateListItem2.add(new CategoryItem(8, "My Hero Academia", R.drawable.pain, null));

        List<CategoryItem> homeCateListItem3 = new ArrayList<>();
        homeCateListItem3.add(new CategoryItem(9, "One Piece", R.drawable.sasuke, null));
        homeCateListItem3.add(new CategoryItem(10, "Naruto", R.drawable.gaara, null));
        homeCateListItem3.add(new CategoryItem(11, "My Hero Academia", R.drawable.pain, null));
        homeCateListItem3.add(new CategoryItem(12, "Dragon Ball z", R.drawable.dbz, null));

        List<CategoryItem> homeCateListItem4 = new ArrayList<>();
        homeCateListItem4.add(new CategoryItem(13, "My Hero Academia", R.drawable.pain, null));
        homeCateListItem4.add(new CategoryItem(14, "One Piece", R.drawable.sasuke, null));
        homeCateListItem4.add(new CategoryItem(15, "Dragon Ball z", R.drawable.dbz, null));
        homeCateListItem4.add(new CategoryItem(16, "Naruto", R.drawable.gaara, null));

        categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Nouveautés", homeCateListItem1));
        categoryList.add(new Category(2, "Classiques", homeCateListItem2));
        categoryList.add(new Category(3, "Découvertes", homeCateListItem3));
        categoryList.add(new Category(4, "Sortie du jour", homeCateListItem4));

        setMainRecycler((categoryList));


    }

    public void setMainRecycler(List<Category> categoryList) {
        mainRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mainRecycler.setLayoutManager(layoutManager);
        mainAdapter = new MainAdapter(this, categoryList);
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