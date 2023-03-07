package com.example.projet;

import java.util.List;

public class Category {

    String CategoryTitle;
    Integer CategotyId;
    private List<CategoryItem> categoryItemList =null;

    public Category(Integer categoryId,String categoryTitle, List<CategoryItem> categoryItemList) {
        CategoryTitle = categoryTitle;
        CategotyId = categoryId;
        this.categoryItemList = categoryItemList;
    }

    public List<CategoryItem> getCategoryItemList() {
        return categoryItemList;
    }

    public void setCategoryItemList(List<CategoryItem> categoryItemList) {
        this.categoryItemList = categoryItemList;
    }

    public String getCategoryTitle() {
        return CategoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        CategoryTitle = categoryTitle;
    }

    public Integer getCategoryId() {
        return CategotyId;
    }

    public void setCategoryId(Integer categotyId) {
        CategotyId = categotyId;
    }
}
