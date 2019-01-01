package com.example.macbook.nestedrecyclerview.model;

public class ModelVertical {


    private int imageAdv;
    private String titleAdv;
    private String descriptionAdv;

    public ModelVertical(String descriptionAdv, int imageAdv, String titleAdv) {
        this.descriptionAdv = descriptionAdv;
        this.imageAdv = imageAdv;
        this.titleAdv = titleAdv;
    }

    public String getDescriptionAdv() {
        return descriptionAdv;
    }

    public void setDescriptionAdv(String descriptionAdv) {
        this.descriptionAdv = descriptionAdv;
    }

    public int getImageAdv() {
        return imageAdv;
    }

    public void setImageAdv(int imageAdv) {
        this.imageAdv = imageAdv;
    }

    public String getTitleAdv() {
        return titleAdv;
    }

    public void setTitleAdv(String titleAdv) {
        this.titleAdv = titleAdv;
    }

}
