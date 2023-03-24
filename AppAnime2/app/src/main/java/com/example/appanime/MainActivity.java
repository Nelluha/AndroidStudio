package com.example.appanime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.appanime.Adapter.AnimePageAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static String JSON_URL = "https://api.jikan.moe/v4/top/anime";

    List<AnimeModelClass> animeList;
    RecyclerView recyclerView;
    AnimePageAdapter animePageAdapter;
    ImageView animeDetailImage;
    TextView animeDetailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animeDetailImage = findViewById(R.id.image_item);
        animeDetailText = findViewById(R.id.nom_item);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        animeList = new ArrayList<>();

        GetData getData = new GetData();
        getData.execute();
    }


    public class GetData extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {


            String current = "";

            try {
                URL url;
                HttpURLConnection urlConnection = null;

                try {
                    url = new URL(JSON_URL);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    InputStream is = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);

                    int data = isr.read();
                    while (data != -1) {
                        current += (char) data;
                        data = isr.read();

                    }
                    return current;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return current;
        }

        @Override
        protected void onPostExecute(String s) {
            AnimeModelClass model = new AnimeModelClass();


            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("data");

                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    model.setAnimeId(jsonObject1.getString("mal_id"));
                    model.setAnimeTitle(jsonObject1.getString("title"));
                    model.setAnimeImg(jsonObject1.getString("images"));


                    animeList.add(model);
                }

            } catch (JSONException e) {
                throw new RuntimeException(e);
            }


            setMainRecycler(animeList);

        }
    }

    public void setMainRecycler(List<AnimeModelClass> animeList) {
        recyclerView = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        animePageAdapter = new AnimePageAdapter(this, animeList);
        recyclerView.setAdapter(animePageAdapter);


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