package com.example.appanime;

public class AnimeModelClass {

    String animeId;
    String animeTitle;
    String animeImg;

    public AnimeModelClass(String animeId, String animeTitle, String animeImg) {
        this.animeId = animeId;
        this.animeTitle = animeTitle;
        this.animeImg = animeImg;
    }

    public AnimeModelClass() {
    }

    public String getAnimeId() {
        return animeId;
    }

    public void setAnimeId(String animeId) {
        this.animeId = animeId;
    }

    public String getAnimeTitle() {
        return animeTitle;
    }

    public void setAnimeTitle(String animeTitle) {
        this.animeTitle = animeTitle;
    }

    public String getAnimeImg() {
        return animeImg;
    }

    public void setAnimeImg(String animeImg) {
        this.animeImg = animeImg;
    }
}
