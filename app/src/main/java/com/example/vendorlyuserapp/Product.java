package com.example.vendorlyuserapp;

public class Product {
    String name,price,imgurl;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public Product(String name, String price, String imgurl) {
        this.name = name;
        this.price = price;
        this.imgurl = imgurl;
    }
}
