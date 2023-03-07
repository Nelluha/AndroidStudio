package com.example.projet;

import java.util.List;

public class Saison {

    Integer id;
    String num;
    List<Episode> episodeList = null;
    static String type;

    public Saison(Integer id, String num,String type, List<Episode> episodeList) {
        this.id = id;
        this.num = num;
        this.episodeList = episodeList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public List<Episode> getEpisodeList() {
        return episodeList;
    }

    public void setEpisodeList(List<Episode> episodeList) {
        this.episodeList = episodeList;
    }

    public static String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
