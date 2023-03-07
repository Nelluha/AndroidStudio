package com.example.projet;

import java.util.List;

public class Type {
    Integer TypeId;
    String TypeName;
    private List<Saison> saisonList = null;

    public Type(Integer typeId, String typeName,List<Saison> saisonList) {
        this.saisonList = saisonList;
        this.TypeId = typeId;
        this.TypeName = typeName;
    }

    public Integer getTypeId() {
        return TypeId;
    }

    public void setTypeId(Integer typeId) {
        TypeId = typeId;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String typeName) {
        TypeName = typeName;
    }

    public List<Saison> getSaisonList() {
        return saisonList;
    }

    public void setSaisonList(List<Saison> saisonList) {
        this.saisonList = saisonList;
    }
}
