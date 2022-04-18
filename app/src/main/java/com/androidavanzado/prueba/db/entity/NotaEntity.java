package com.androidavanzado.prueba.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName ="notas")
public class NotaEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;
    public String content;
    public Boolean favorite;
    public String color;

    public NotaEntity(String title, String content, Boolean favorite, String color) {
        this.title = title;
        this.content = content;
        this.favorite = favorite;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
