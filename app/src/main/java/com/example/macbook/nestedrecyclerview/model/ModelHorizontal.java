package com.example.macbook.nestedrecyclerview.model;

public class ModelHorizontal {

    private String titleMovie;
    private int imageMovie;


    public ModelHorizontal(String titleMovie, int imageMovie) {
        this.titleMovie = titleMovie;
        this.imageMovie = imageMovie;
    }

    public String getTitleMovie() {
        return titleMovie;
    }

    public void setTitleMovie(String titleMovie) {
        this.titleMovie = titleMovie;
    }

    public int getImageMovie() {
        return imageMovie;
    }

    public void setImageMovie(int imageMovie) {
        this.imageMovie = imageMovie;
    }


}
