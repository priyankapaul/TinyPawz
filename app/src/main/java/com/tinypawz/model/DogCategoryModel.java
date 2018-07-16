package com.tinypawz.model;

public class DogCategoryModel {
    private String dogName, dogDescription;
    private int dogImgUrl;

    public DogCategoryModel() {
    }

    public DogCategoryModel(String dogName, String dogDescription, int dogImgUrl) {
        this.dogName = dogName;
        this.dogDescription = dogDescription;
        this.dogImgUrl = dogImgUrl;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getDogDescription() {
        return dogDescription;
    }

    public void setDogDescription(String dogDescription) {
        this.dogDescription = dogDescription;
    }

    public int getDogImgUrl() {
        return dogImgUrl;
    }

    public void setDogImgUrl(int dogImgUrl) {
        this.dogImgUrl = dogImgUrl;
    }


}