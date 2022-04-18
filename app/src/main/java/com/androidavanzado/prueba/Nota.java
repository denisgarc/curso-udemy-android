package com.androidavanzado.prueba;

public class Nota {
    private String title;
    private String content;
    private Boolean isFavorite;
    private int color;

    public Nota(String title, String content, Boolean isFavorite, int color) {
        this.title = title;
        this.content = content;
        this.isFavorite = isFavorite;
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getFavorite() {
        return isFavorite;
    }

    public void setFavorite(Boolean favorite) {
        isFavorite = favorite;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
