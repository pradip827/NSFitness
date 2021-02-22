package com.nsfitness.ns_splash;

public class DataClass {

    private String description,Price,Offer;
    private int imgId;
    public DataClass(String description, String Price,String Offer,int imgId) {
        this.description = description;
        this.Price= Price;
        this.Offer= Offer;
        this.imgId = imgId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getOffer() {
        return Offer;
    }

    public void setOffer(String offer) {
        Offer = offer;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
