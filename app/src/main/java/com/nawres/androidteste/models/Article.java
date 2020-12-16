package com.nawres.androidteste.models;

public class Article {
    int image_artcile;
    String title_artcile;
    String description_artcile;


    public Article(int image_artcile, String title_artcile, String description_artcile) {
        this.image_artcile = image_artcile;
        this.title_artcile = title_artcile;
        this.description_artcile = description_artcile;
    }

    public int getImage_artcile() {
        return image_artcile;
    }

    public void setImage_artcile(int image_artcile) {
        this.image_artcile = image_artcile;
    }

    public String getTitle_artcile() {
        return title_artcile;
    }

    public void setTitle_artcile(String title_artcile) {
        this.title_artcile = title_artcile;
    }

    public String getDescription_artcile() {
        return description_artcile;
    }

    public void setDescription_artcile(String description_artcile) {
        this.description_artcile = description_artcile;
    }
}

