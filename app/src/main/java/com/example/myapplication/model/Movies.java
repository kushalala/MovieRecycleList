package com.example.myapplication.model;

public class Movies {

    private String title;
    private String genre;
    private String description;
    private int price;
    private String image_url;

    public Movies()
    {

    }

    public Movies(String title, String genre, String description, int price, String image_url) {
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.price = price;
        this.image_url = image_url;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
