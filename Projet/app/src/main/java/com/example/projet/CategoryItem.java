package com.example.projet;

import java.util.List;

public class CategoryItem {
    private String name;
    private Integer image;
    private Integer id;

    private List<Saison> saisonList;

    public CategoryItem(Integer id,String name, Integer image, List<Saison>saisonList) {
        this.saisonList=saisonList;
        this.id=id;
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Saison> getSaisonList() {
        return saisonList;
    }



    public void setSaisonList(List<Saison> saisonList) {
        this.saisonList = saisonList;
    }
}
