package com.example.myjihc;

public class Furniture {
    int photo;
    String title;
    String desc;
    int count;
    int price;

    public Furniture(int photo, String title, String desc, int count, int price) {
        this.photo = photo;
        this.title = title;
        this.desc = desc;
        this.count = count;
        this.price = price;
    }

    public Furniture(/*?*/int log, String джоконда, String desc, String s, String s1) {
    }

    public int getPhoto() {
        return photo;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }
}
