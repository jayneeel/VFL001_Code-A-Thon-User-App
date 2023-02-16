package com.example.vendorlyuserapp;

public class Details {
    String shopname,address,phone,area;

    public Details() {
    }

    public Details(String shopname, String address, String phone, String area) {
        this.shopname = shopname;
        this.address = address;
        this.phone = phone;
        this.area = area;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
