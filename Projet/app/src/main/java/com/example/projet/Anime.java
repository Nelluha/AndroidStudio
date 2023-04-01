package com.example.projet;

import java.util.List;

public class Anime {
    private String title,image,id,synopsis;
    String liked = "0";


    public Anime(String id,String title,String image,String synopsis,String liked) {
        this.synopsis = synopsis;
        this.title = title;
        this.image = image;
        this.liked = liked;
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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getLiked() {
        return liked;
    }

    public void setLiked(String liked) {
        this.liked = liked;
    }
}
