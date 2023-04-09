package com.example.utilisateur;

import android.app.Dialog;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.List;

import adapter.MainAdapter;


public class PopUp extends Dialog {


    private TextView animeName;
    private ImageView like, animeImage;
    private String aTitle,aImage;
    MainAdapter adapter;
    List<Anime> animeList;
    int position;
    MainActivity activity;
    Context context;


    public PopUp(Context context) {
        super(context);

/*Une popup de l'anime selectionné s'affiche avec la possibilité d'ajouter
cette anime en favoris en cliquant sur le coeur
 */

        setContentView(R.layout.popup);
        animeName = findViewById(R.id.popupName);
        animeImage = findViewById(R.id.popupImage);
        like = findViewById(R.id.popupLike);

       /* like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(aTitle.existPasDansBdd){
                    like.setBackgroundResource(R.drawable.ic_like);
                    + ajout dans la bdd
                }else{
                    like.setBackgroundResource(R.drawable.ic_unlike);
                    + remove de la bdd
                }


                }
        });*/


        }

    public void build() {
        show();
        animeName.setText(aTitle);

    }


    public void setAnimeName(String aTitle) {
        this.aTitle = aTitle;
    }

    public void setAnimeImage(String aImage){
        this.aImage = aImage;
    }

    public ImageView getimageview(){
        return animeImage;
    }

    }

