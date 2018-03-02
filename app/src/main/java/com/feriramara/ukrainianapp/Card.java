package com.feriramara.ukrainianapp;

/**
 * Created by Alex on 21.02.2018.
 */

public class Card {

    private String poetryName;
    private String authorName;
    private String text;
    private int favorites;
    private int id;


    public Card () {}

    public Card(int id, String authorName, String poetryName, int favorites, String text) {
        this.id = id;
        this.poetryName = poetryName;
        this.authorName = authorName;
        this.text = text;
        this.favorites = favorites;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }



    public String getPoetryName() {
        return poetryName;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }


    public void setPoetryName(String poetryName) {
        this.poetryName = poetryName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
