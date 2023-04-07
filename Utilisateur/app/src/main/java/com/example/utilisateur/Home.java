package com.example.utilisateur;



import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import adapter.MainAdapter;

public class Home extends Fragment {


    String Jsonurl;
    SearchView searchView;


    RecyclerView mainRecycler;
    List<Anime> animeList = new ArrayList<>();
    MainAdapter mainAdapter = new MainAdapter(this.getContext(),animeList);
    List<Anime> filteredList = new ArrayList<>();


    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home, container, false);


        Jsonurl = "https://api.jikan.moe/v4/top/anime";
/*
        animeList.add(new Anime("1735", "naruto shippuden", "https://1.bp.blogspot.com/-A5IKARiFIWk/XO5DGx2NTMI/AAAAAAAAQj0/sRS1liSORB4VBtJKWkxX_r_h3zqnsYFMQCLcBGAs/s2560/trunks-dragon-ball-super-hd-2048x2048.jpg", "Dans un futur proche suite à une mutation génétique, 80% de la population mondiale possède des super-pouvoirs appelés \" alters\"les super-héros protègent la population"));
        animeList.add(new Anime("813", "dragon ball z", "https://th.bing.com/th/id/R.095580a9b2af07c03756a261a721cfb3?rik=lePs4s9ZjaCDIA&pid=ImgRaw&r=0", "Dans un futur proche suite à une mutation génétique, 80% de la population mondiale possède des super-pouvoirs appelés \" alters\"les super-héros protègent la population"));
        animeList.add(new Anime("21", "one piece", "https://1.bp.blogspot.com/-A5IKARiFIWk/XO5DGx2NTMI/AAAAAAAAQj0/sRS1liSORB4VBtJKWkxX_r_h3zqnsYFMQCLcBGAs/s2560/trunks-dragon-ball-super-hd-2048x2048.jpg", "Dans un futur proche suite à une mutation génétique, 80% de la population mondiale possède des super-pouvoirs appelés \" alters\"les super-héros protègent la population"));
        animeList.add(new Anime("31964", "my hero academia", "https://1.bp.blogspot.com/-A5IKARiFIWk/XO5DGx2NTMI/AAAAAAAAQj0/sRS1liSORB4VBtJKWkxX_r_h3zqnsYFMQCLcBGAs/s2560/trunks-dragon-ball-super-hd-2048x2048.jpg", "Dans un futur proche suite à une mutation génétique, 80% de la population mondiale possède des super-pouvoirs appelés \" alters\"les super-héros protègent la population mondiale face aux super-vilains qui utilisent leur alter à des=\"\" fins=\"\" maléfiques.=\"\" le=\"\" plus=\"\" célèbre=\"\" super-héro=\"\" se=\"\" nomme=\"\" all=\"\" might.=\"\" izuku=\"\" midoriya=\"\" en=\"\" est=\"\" fan,=\"\" et=\"\" rêve=\"\" d'intégrer=\"\" filière=\"\" super-héroïque=\"\" du=\"\" lycée=\"\" yuei=\"\" pour=\"\" suivre=\"\" traces=\"\" de=\"\" son=\"\" idole=\"\" ainsi=\"\" devenir=\"\" grand=\"\" super-héros.=\"\" malheureusement,=\"\" ne=\"\" possède=\"\" pas=\"\" pouvoir.\"=\"\">"));
*/

        GetData getData = new GetData();
        getData.execute();




        searchView = view.findViewById(R.id.searchbar);
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
        return view;
    }

    private void filterList(String newText) {
        for (Anime anime : animeList) {
            if (anime.getTitle().toLowerCase().contains(newText.toLowerCase())) {
               // Toast.makeText(this.getContext(), "ICI", Toast.LENGTH_SHORT).show();
                filteredList.add(anime);
                Toast.makeText(this.getContext(), anime.getTitle(), Toast.LENGTH_SHORT).show();


            }
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(this.getContext(), "Aucun résultat pour cette recherche", Toast.LENGTH_SHORT).show();
        }else {
            mainAdapter.setFilteredList(filteredList);


        }


    }


    private class GetData extends AsyncTask<String,String,String> {

        @Override
        protected String doInBackground(String... strings) {

            String current="";

            try{
                URL url;
                HttpURLConnection urlConnection = null;
                try{
                    url = new URL(Jsonurl);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    InputStream is = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);

                    int data = isr.read();
                    while(data != -1){
                        current += (char) data;
                        data = isr.read();
                    }
                    return current;
                }catch (MalformedURLException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }finally {
                    if(urlConnection != null){
                        urlConnection.disconnect();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return current;
        }

        @Override
        protected void onPostExecute(String s) {

            try{
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("data");

                for(int i=0; i<jsonArray.length();i++){
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    Anime anime = new Anime();
                    anime.setTitle(jsonObject1.getString("title"));
                    anime.setImage(jsonObject1.getString("image_url"));
                    anime.setSynopsis(jsonObject1.getString("synopsis"));

                    animeList.add(anime);

                }

            }catch(JSONException e){
                e.printStackTrace();
            }


        }

        }

    }
