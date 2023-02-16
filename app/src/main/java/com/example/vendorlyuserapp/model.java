package com.example.vendorlyuserapp;

public class model {
    String imgurl, prodName, price,shopName;

    public model() {
    }

    public model(String imgurl, String prodName, String price, String shopName) {
        this.imgurl = imgurl;
        this.prodName = prodName;
        this.price = price;
        this.shopName = shopName;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
