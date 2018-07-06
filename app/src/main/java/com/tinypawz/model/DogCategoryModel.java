package com.tinypawz.model;

public class DogCategoryModel {
    private String dogName, dogDescription, dogImgUrl;

    public DogCategoryModel() {
    }

    public DogCategoryModel(String dogName, String dogDescription, String dogImgUrl) {
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

    public String getDogImgUrl() {
        return dogImgUrl;
    }

    public void setDogImgUrl(String dogImgUrl) {
        this.dogImgUrl = dogImgUrl;
    }


}