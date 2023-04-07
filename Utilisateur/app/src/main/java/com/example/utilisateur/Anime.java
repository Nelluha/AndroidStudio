package com.example.utilisateur;

import java.util.List;

public class Anime {
    private String title,image,synopsis;



    public Anime(String title,String image,String synopsis) {
        this.synopsis = synopsis;
        this.title = title;
        this.image = image;

    }

    public Anime(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

}
